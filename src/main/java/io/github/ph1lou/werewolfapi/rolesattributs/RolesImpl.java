package io.github.ph1lou.werewolfapi.rolesattributs;

import io.github.ph1lou.werewolfapi.GetWereWolfAPI;
import io.github.ph1lou.werewolfapi.PlayerWW;
import io.github.ph1lou.werewolfapi.WereWolfAPI;
import io.github.ph1lou.werewolfapi.enumlg.Camp;
import io.github.ph1lou.werewolfapi.enumlg.Day;
import io.github.ph1lou.werewolfapi.enumlg.Sounds;
import io.github.ph1lou.werewolfapi.enumlg.State;
import io.github.ph1lou.werewolfapi.events.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public abstract class RolesImpl implements Roles, Listener,Cloneable {
    
    public final WereWolfAPI game;
    public final GetWereWolfAPI main;

    @NotNull
    private UUID uuid;
    private Boolean infected = false;

    public RolesImpl(GetWereWolfAPI main, WereWolfAPI game, @NotNull UUID uuid){
        this.game=game;
        this.main = main;
        this.uuid=uuid;
    }

    @Override
    public boolean isCamp(@NotNull Camp camp) {
        return(getCamp().equals(camp));
    }

    @Nullable
    @Override
    public Player recoverPower() {

        Player player = Bukkit.getPlayer(uuid);

        if (player==null) return null;

        PlayerWW plg = game.getPlayersWW().get(uuid);
        plg.setKit(true);
        Sounds.EXPLODE.play(player);
        player.performCommand("ww role");
        player.sendMessage(game.translate("werewolf.announcement.review_role"));

        recoverPotionEffect(player);

        if(!game.getStuffs().getStuffRoles().containsKey(getDisplay())){
            Bukkit.getConsoleSender().sendMessage("[WereWolfPlugin] invalid addon structure");
            return player;
        }

        for(ItemStack i:game.getStuffs().getStuffRoles().get(plg.getRole().getDisplay())) {

            if(player.getInventory().firstEmpty()==-1) {
                player.getWorld().dropItem(player.getLocation(),i);
            }
            else {
                player.getInventory().addItem(i);
                player.updateInventory();
            }
        }

        return player;
    }

    @NotNull
    @Override
    public Camp getCamp() {
        return isNeutral()?Camp.NEUTRAL:isWereWolf()?Camp.WEREWOLF:Camp.VILLAGER;
    }

    @NotNull
    @Override
    public UUID getPlayerUUID(){
        return uuid;
    }

    @Override
    public void setPlayerUUID(@NotNull UUID uuid) {
        this.uuid=uuid;
    }

    @Override
    public void stolen(@NotNull UUID uuid) {
    }

    @Override
    public boolean isDisplay(String s) {
        return s.equals(this.getDisplay());
    }


    @Override
    public Roles publicClone() {
        try {
            return (Roles) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @EventHandler
    public void onWereWolfList(WereWolfListEvent event){

        PlayerWW lg = game.getPlayersWW().get(uuid);

        if(!isWereWolf()) return;

        if(!lg.isState(State.ALIVE)) return;

        Player player = Bukkit.getPlayer(uuid);

        if (player == null) return;

        player.sendMessage(game.translate("werewolf.role.werewolf.see_others"));
        Sounds.WOLF_HOWL.play(player);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onNewWereWolf(NewWereWolfEvent event) {

        if(event.isCancelled()) return;

        PlayerWW plg = game.getPlayersWW().get(uuid);

        if(!uuid.equals(event.getUuid())) return;

        Player player = Bukkit.getPlayer(uuid);

        if(player!=null) {

            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,Integer.MAX_VALUE,0,false,false));
            player.sendMessage(game.translate("werewolf.role.werewolf.go_to_the_werewolf_camp"));
            Sounds.WOLF_HOWL.play(player);
            if (game.isDay(Day.NIGHT)) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE,-1,false,false));
            }
        }

        for(PlayerWW playerWW:game.getPlayersWW().values()){
            if(playerWW.getRole().isWereWolf()) {
                if (plg.isState(State.ALIVE) ) {
                    UUID uuid1 = playerWW.getRole().getPlayerUUID();
                    Player lg1 = Bukkit.getPlayer(uuid1);

                    if (lg1 != null) {
                        lg1.sendMessage(game.translate("werewolf.role.werewolf.new_werewolf"));
                        Sounds.WOLF_HOWL.play(lg1);
                    }
                }
            }
        }

        Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) main,() -> Bukkit.getPluginManager().callEvent(new UpdateNameTagEvent()), 10L);
    }

    @EventHandler
    private void onPlayerDeathForInfected(PlayerDeathEvent event) {

        if(!infected) return;

        if(event.getEntity().getKiller()==null) return;
        Player killer = event.getEntity().getKiller();

        if(!killer.getUniqueId().equals(getPlayerUUID())) return;

        killer.removePotionEffect(PotionEffectType.ABSORPTION);
        killer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 0, false, false));
        killer.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1200, 0, false, false));
    }

    @Override
    public boolean isWereWolf() {
        return infected;
    }

    @Override
    public boolean getInfected() {
        return infected;
    }

    @Override
    public void setInfected(Boolean infected) {
        this.infected = infected;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onInfectedDay(DayEvent event) {

        if (!getInfected()) return;

        if (!game.getPlayersWW().get(getPlayerUUID()).isState(State.ALIVE)) return;

        Player player = Bukkit.getPlayer(getPlayerUUID());

        if(player==null) return;

        player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInfectedNight(NightEvent event) {

        if (!getInfected()) return;

        if (!game.getPlayersWW().get(getPlayerUUID()).isState(State.ALIVE)) return;

        Player player = Bukkit.getPlayer(getPlayerUUID());

        if(player==null) return;

        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, -1, false, false));
    }

    @EventHandler
    public void onEndPlayerMessageInfected(EndPlayerMessageEvent event){

        if(!infected) return;

        if(!event.getPlayerUUID().equals(getPlayerUUID())) return;

        StringBuilder sb = event.getEndMessage();

        sb.append(game.translate("werewolf.end.infect"));
    }

    @Override
    public void recoverPotionEffect(@NotNull Player player) {

    }
}