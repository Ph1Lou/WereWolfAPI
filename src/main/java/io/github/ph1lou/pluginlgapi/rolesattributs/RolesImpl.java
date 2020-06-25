package io.github.ph1lou.pluginlgapi.rolesattributs;

import io.github.ph1lou.pluginlgapi.GetWereWolfAPI;
import io.github.ph1lou.pluginlgapi.PlayerWW;
import io.github.ph1lou.pluginlgapi.WereWolfAPI;
import io.github.ph1lou.pluginlgapi.enumlg.Camp;
import io.github.ph1lou.pluginlgapi.enumlg.Day;
import io.github.ph1lou.pluginlgapi.enumlg.State;
import io.github.ph1lou.pluginlgapi.events.*;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.UUID;

public abstract class RolesImpl implements Roles, Listener,Cloneable {
    
    public final WereWolfAPI game;
    public final GetWereWolfAPI main;
    private UUID uuid;
    private Boolean infected = false;

    public RolesImpl(GetWereWolfAPI main, WereWolfAPI game, UUID uuid){
        this.game=game;
        this.main = main;
        this.uuid=uuid;
    }

    @Override
    public boolean isCamp(Camp camp) {
        return(getCamp().equals(camp));
    }

    @Override
    public Player recoverPower() {

        if (Bukkit.getPlayer(uuid)==null) return null;

        Player player = Bukkit.getPlayer(uuid);
        PlayerWW plg = game.getPlayersWW().get(uuid);
        plg.setKit(true);

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

    @Override
    public Camp getCamp() {
        return isNeutral()?Camp.NEUTRAL:isWereWolf()?Camp.WEREWOLF:Camp.VILLAGER;
    }

    @Override
    public UUID getPlayerUUID(){
        return uuid;
    }

    @Override
    public void setPlayerUUID(UUID uuid) {
        this.uuid=uuid;
    }

    @Override
    public void stolen(UUID uuid) {
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

        if (Bukkit.getPlayer(uuid) == null) return;

        Player player = Bukkit.getPlayer(uuid);
        player.sendMessage(game.translate("werewolf.role.werewolf.see_others"));
        player.playSound(player.getLocation(), Sound.WOLF_HOWL, 1, 20);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onNewWereWolf(NewWereWolfEvent event) {

        if(event.isCancelled()) return;

        PlayerWW plg = game.getPlayersWW().get(uuid);

        if(!uuid.equals(event.getUuid())) return;

        if(Bukkit.getPlayer(uuid)!=null) {
            Player player = Bukkit.getPlayer(uuid);
            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,Integer.MAX_VALUE,0,false,false));
            player.sendMessage(game.translate("werewolf.role.werewolf.go_to_the_werewolf_camp"));
            player.playSound(player.getLocation(), Sound.WOLF_HOWL, 1, 20);
            if (game.isDay(Day.NIGHT)) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE,-1,false,false));
            }
        }

        for(PlayerWW playerWW:game.getPlayersWW().values()){
            if(playerWW.getRole().isWereWolf()) {
                if (plg.isState(State.ALIVE) ) {
                    UUID uuid1 = playerWW.getRole().getPlayerUUID();
                    if (Bukkit.getPlayer(uuid1) != null) {
                        Player lg1 = Bukkit.getPlayer(uuid1);
                        lg1.sendMessage(game.translate("werewolf.role.werewolf.new_werewolf"));
                        lg1.playSound(lg1.getLocation(), Sound.WOLF_HOWL, 1, 20);
                    }
                }
            }
        }
    }

    @EventHandler
    private void onPlayerDeath(PlayerDeathEvent event) {

        if(!infected) return;

        if(event.getEntity() == null) return;
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


        if(Bukkit.getPlayer(getPlayerUUID())==null){
            return;
        }

        Player player = Bukkit.getPlayer(getPlayerUUID());

        player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInfectedNight(NightEvent event) {

        if (!getInfected()) return;

        if (!game.getPlayersWW().get(getPlayerUUID()).isState(State.ALIVE)) return;

        if(Bukkit.getPlayer(getPlayerUUID())==null){
            return;
        }
        Player player = Bukkit.getPlayer(getPlayerUUID());

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
    public void recoverPotionEffect(Player player) {

    }
}