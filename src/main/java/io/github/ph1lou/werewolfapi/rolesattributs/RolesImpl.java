package io.github.ph1lou.werewolfapi.rolesattributs;

import io.github.ph1lou.werewolfapi.GetWereWolfAPI;
import io.github.ph1lou.werewolfapi.PlayerWW;
import io.github.ph1lou.werewolfapi.WereWolfAPI;
import io.github.ph1lou.werewolfapi.enumlg.Camp;
import io.github.ph1lou.werewolfapi.enumlg.Day;
import io.github.ph1lou.werewolfapi.enumlg.Sounds;
import io.github.ph1lou.werewolfapi.enumlg.StatePlayer;
import io.github.ph1lou.werewolfapi.events.*;
import io.github.ph1lou.werewolfapi.versions.VersionUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.UUID;

public abstract class RolesImpl implements Roles, Listener,Cloneable {
    
    public final WereWolfAPI game;
    public final GetWereWolfAPI main;

    @NotNull
    private UUID uuid;
    private Boolean infected = false;
    @NotNull
    private final String key;

    public RolesImpl(GetWereWolfAPI main, WereWolfAPI game, @NotNull UUID uuid,@NotNull String key){
        this.game=game;
        this.main = main;
        this.uuid=uuid;
        this.key=key;
    }

    @Override
    public boolean isCamp(@NotNull Camp camp) {
        return(getCamp().equals(camp));
    }

    @Override
    public @NotNull String getKey() {
        return key;
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

        if(!game.getStuffs().getStuffRoles().containsKey(getKey())){
            Bukkit.getConsoleSender().sendMessage("[WereWolfPlugin] invalid addon structure");
            return player;
        }

        for(ItemStack i:game.getStuffs().getStuffRoles().get(plg.getRole().getKey())) {

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
    public boolean isKey(String s) {
        return s.equals(this.getKey());
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

    @EventHandler(priority = EventPriority.LOWEST)
    public void onRecoverHeart(DayEvent event) {

        PlayerWW playerWW = game.getPlayerWW(getPlayerUUID());

        if(playerWW==null) return;

        if (!playerWW.isState(StatePlayer.ALIVE)) return;

        Player player = Bukkit.getPlayer(getPlayerUUID());

        if (player == null) return;

        if (playerWW.getLostHeart() > 0) {
            VersionUtils.getVersionUtils().setPlayerMaxHealth(player, VersionUtils.getVersionUtils().getPlayerMaxHealth(player) + playerWW.getLostHeart());
            playerWW.clearLostHeart();
        }

    }

    @EventHandler
    public void onModeratorScoreBoard(UpdateModeratorNameTag event){

        PlayerWW playerWW = game.getPlayerWW(getPlayerUUID());
        StringBuilder sb = new StringBuilder(event.getSuffix());
        StringBuilder sb2 = new StringBuilder(event.getPrefix());
        if(!event.getPlayerUUID().equals(getPlayerUUID())) return;

        if(playerWW==null) return;

        if(playerWW.isState(StatePlayer.DEATH)){
            return;
        }


        if(!playerWW.getLovers().isEmpty()){
            sb.append(ChatColor.LIGHT_PURPLE).append("L ");
        }

        if(playerWW.getAmnesiacLoverUUID()!=null){
            sb.append(ChatColor.DARK_PURPLE).append("AL ");
        }

        if(playerWW.getCursedLovers()!=null){
            sb.append(ChatColor.BLACK).append("CL ");
        }

        if(isNeutral()){
            sb2.append(ChatColor.GOLD);
        }
        else if(isWereWolf()){
            sb2.append(ChatColor.DARK_RED);
        }
        else sb2.append(ChatColor.GREEN);

        event.setPrefix(sb2.toString());
        event.setSuffix(sb.toString());
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onRequestWereWolfList(RequestSeeWereWolfListEvent event){

        if(!event.getPlayerUUID().equals(getPlayerUUID())) return;
        if(game.getPlayersWW().get(getPlayerUUID()).isState(StatePlayer.DEATH)) return;

        if (game.getConfig().getTimerValues().get("werewolf.menu.timers.werewolf_list") <= 0) {
            event.setAccept(isWereWolf());
        }

    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onAppearInWereWolfList(AppearInWereWolfListEvent event){

        if(!event.getPlayerUUID().equals(getPlayerUUID())) return;
        if(game.getPlayersWW().get(getPlayerUUID()).isState(StatePlayer.DEATH)) return;
        event.setAppear(isWereWolf());
    }

    @EventHandler
    public void onWereWolfList(WereWolfListEvent event){

        PlayerWW lg = game.getPlayersWW().get(uuid);

        if(!isWereWolf()) return;

        if(!lg.isState(StatePlayer.ALIVE)) return;

        Player player = Bukkit.getPlayer(uuid);

        if (player == null) return;

        player.sendMessage(game.translate("werewolf.role.werewolf.see_others"));
        Sounds.WOLF_HOWL.play(player);
    }

    @EventHandler
    public void onNewWereWolf(NewWereWolfEvent event) {

        if(event.isCancelled()) return;

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

        game.getPlayersWW().values().stream()
                .filter(playerWW -> playerWW.getRole().isWereWolf())
                .filter(playerWW -> playerWW.isState(StatePlayer.ALIVE))
                .map(playerWW -> Bukkit.getPlayer(playerWW.getRole().getPlayerUUID()))
                .filter(Objects::nonNull)
                .forEach(player1 -> {
                    player1.sendMessage(game.translate("werewolf.role.werewolf.new_werewolf"));
                    Sounds.WOLF_HOWL.play(player1);
                });


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

        if (!game.getPlayersWW().get(getPlayerUUID()).isState(StatePlayer.ALIVE)) return;

        Player player = Bukkit.getPlayer(getPlayerUUID());

        if(player==null) return;

        player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInfectedNight(NightEvent event) {

        if (!getInfected()) return;

        if (!game.getPlayersWW().get(getPlayerUUID()).isState(StatePlayer.ALIVE)) return;

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