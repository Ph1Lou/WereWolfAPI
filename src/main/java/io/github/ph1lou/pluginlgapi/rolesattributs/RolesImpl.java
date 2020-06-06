package io.github.ph1lou.pluginlgapi.rolesattributs;

import io.github.ph1lou.pluginlgapi.GetWereWolfAPI;
import io.github.ph1lou.pluginlgapi.PlayerWW;
import io.github.ph1lou.pluginlgapi.WereWolfAPI;
import io.github.ph1lou.pluginlgapi.enumlg.*;
import io.github.ph1lou.pluginlgapi.events.*;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Team;

import java.util.UUID;

public abstract class RolesImpl implements Roles, Listener,Cloneable {
    
        public final WereWolfAPI game;
        public final GetWereWolfAPI main;
        private Camp camp = Camp.VILLAGER;
        private UUID uuid;
        private Boolean infected = false;
    
        public RolesImpl(GetWereWolfAPI main, WereWolfAPI game, UUID uuid){
            this.game=game;
            this.main = main;
            this.uuid=uuid;
        }
    
    
        @Override
        public void setCamp(Camp camp) {
            this.camp=camp;
        }
    
        @Override
        public boolean isCamp(Camp camp) {
            return(this.camp.equals(camp));
        }
    
        @Override
        public Camp getCamp() {
            return(this.camp);
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
        public Boolean isDisplay(String s) {
            return s.equals(this.getDisplay());
        }
    
    
        @Override
        public void recoverPotionEffect(Player player) {
            if (game.getConfig().getScenarioValues().get(ScenarioLG.CAT_EYES)) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,Integer.MAX_VALUE,0,false,false));
            }
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
    
            if(!isWereWolf()){
                return;
            }
    
            Team team=game.getWereWolfScoreBoard().getTeam(lg.getName());
    
            if (game.getConfig().getConfigValues().get(ToolLG.RED_NAME_TAG)) {
                if(game.getHosts().contains(uuid)){
                    team.setPrefix(game.translate("werewolf.commands.admin.host.tag")+"§4");
                }
                else team.setPrefix("§4");
            }
            lg.setScoreBoard(game.getWereWolfScoreBoard());
    
            if(!lg.isState(State.ALIVE)) {
                return;
            }
    
            if (Bukkit.getPlayer(uuid) == null) {
                return;
            }
    
            Player player = Bukkit.getPlayer(uuid);
            player.sendMessage(game.translate("werewolf.role.werewolf.see_others"));
            player.playSound(player.getLocation(), Sound.WOLF_HOWL, 1, 20);
            player.setScoreboard(game.getWereWolfScoreBoard());
        }
    
        @EventHandler(priority = EventPriority.HIGH)
        public void onNewWereWolf(NewWereWolfEvent event) {

            if(event.isCancelled()) return;

            PlayerWW plg = game.getPlayersWW().get(uuid);
    
            if(uuid.equals(event.getUuid())){
    
                setCamp(Camp.WEREWOLF);
    
                if (game.getConfig().getTimerValues().get(TimerLG.WEREWOLF_LIST) < 0) {
    
                    Team team=game.getWereWolfScoreBoard().getTeam(plg.getName());
    
                    if (game.getConfig().getConfigValues().get(ToolLG.RED_NAME_TAG)) {
                        if(game.getHosts().contains(uuid)){
                            team.setPrefix(game.translate("werewolf.commands.admin.host.tag")+"§4");
                        }
                        else team.setPrefix("§4");
                    }
                    plg.setScoreBoard(game.getWereWolfScoreBoard());
                }
    
                if(Bukkit.getPlayer(uuid)!=null) {
                    Player player = Bukkit.getPlayer(uuid);
                    player.setScoreboard(game.getWereWolfScoreBoard());
                    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,Integer.MAX_VALUE,0,false,false));
                    player.sendMessage(game.translate("werewolf.role.werewolf.go_to_the_werewolf_camp"));
                    player.playSound(player.getLocation(), Sound.WOLF_HOWL, 1, 20);
                    if (game.isDay(Day.NIGHT)) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE,-1,false,false));
                    }
                }
            }
            else if(isWereWolf()){
                if (game.getConfig().getTimerValues().get(TimerLG.WEREWOLF_LIST) < 0) {
                    if (plg.isState(State.ALIVE)) {
                        if(Bukkit.getPlayer(uuid) != null){
                            Player lg1 = Bukkit.getPlayer(uuid);
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
        public Boolean getInfected() {
            return infected;
        }
    
        @Override
        public void setInfected(Boolean infected) {
            this.infected = infected;
        }
    
        @EventHandler(priority = EventPriority.LOWEST)
        public void onInfectedDay(DayEvent event) {
    
            if (!game.getPlayersWW().get(getPlayerUUID()).isState(State.ALIVE)) return;
    
            if(Bukkit.getPlayer(getPlayerUUID())==null){
                return;
            }
    
            Player player = Bukkit.getPlayer(getPlayerUUID());
    
            if (getInfected()) {
                player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
            }
        }
    
        @EventHandler(priority = EventPriority.HIGHEST)
        public void onInfectedNight(NightEvent event) {
    
            if (!game.getPlayersWW().get(getPlayerUUID()).isState(State.ALIVE)) return;
    
            if (!getInfected()) {
                return;
            }
    
            if(Bukkit.getPlayer(getPlayerUUID())==null){
                return;
            }
            Player player = Bukkit.getPlayer(getPlayerUUID());
    
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, -1, false, false));
        }
    
        @EventHandler
        public void onEndPlayerMessageInfected(EndPlayerMessageEvent event){
    
            if(!event.getPlayerUUID().equals(getPlayerUUID())) return;
    
            StringBuilder sb = event.getEndMessage();
    
            if(infected){
                sb.append(game.translate("werewolf.end.infect"));
            }
        }
    }