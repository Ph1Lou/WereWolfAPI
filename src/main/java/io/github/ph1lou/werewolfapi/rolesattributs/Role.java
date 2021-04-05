package io.github.ph1lou.werewolfapi.rolesattributs;

import io.github.ph1lou.werewolfapi.GetWereWolfAPI;
import io.github.ph1lou.werewolfapi.IPlayerWW;
import io.github.ph1lou.werewolfapi.WereWolfAPI;
import io.github.ph1lou.werewolfapi.enums.Camp;
import io.github.ph1lou.werewolfapi.enums.ConfigsBase;
import io.github.ph1lou.werewolfapi.enums.Day;
import io.github.ph1lou.werewolfapi.enums.Sound;
import io.github.ph1lou.werewolfapi.enums.StateGame;
import io.github.ph1lou.werewolfapi.enums.StatePlayer;
import io.github.ph1lou.werewolfapi.enums.TimersBase;
import io.github.ph1lou.werewolfapi.events.game.day_cycle.DayEvent;
import io.github.ph1lou.werewolfapi.events.game.day_cycle.NightEvent;
import io.github.ph1lou.werewolfapi.events.game.permissions.UpdateModeratorNameTag;
import io.github.ph1lou.werewolfapi.events.game.utils.CountRemainingRolesCategoriesEvent;
import io.github.ph1lou.werewolfapi.events.game.utils.EndPlayerMessageEvent;
import io.github.ph1lou.werewolfapi.events.game.utils.WinConditionsCheckEvent;
import io.github.ph1lou.werewolfapi.events.werewolf.AppearInWereWolfListEvent;
import io.github.ph1lou.werewolfapi.events.werewolf.NewWereWolfEvent;
import io.github.ph1lou.werewolfapi.events.werewolf.RequestSeeWereWolfListEvent;
import io.github.ph1lou.werewolfapi.events.werewolf.WereWolfCanSpeakInChatEvent;
import io.github.ph1lou.werewolfapi.events.werewolf.WereWolfChatEvent;
import io.github.ph1lou.werewolfapi.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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

import java.util.Objects;
import java.util.UUID;

public abstract class Role implements IRole, Listener,Cloneable {
    
    protected final WereWolfAPI game;
    protected final GetWereWolfAPI main;

    @NotNull
    private UUID uuid;
    private boolean infected = false;
    private boolean transformedToNeutral = false;
    private boolean solitary =false;
    @NotNull
    private IPlayerWW playerWW;
    @NotNull
    private final String key;
    private String deathRole="";

    public Role(@NotNull GetWereWolfAPI main, @NotNull IPlayerWW playerWW, @NotNull String key){
        this.main = main;
        this.game = main.getWereWolfAPI();
        this.uuid= playerWW.getUUID();
        this.playerWW = playerWW;
        this.key=key;
    }

    @Override
    public boolean isNeutral() {
        return this.solitary || this.transformedToNeutral && !this.infected;
    }

    @Override
    public final boolean isTransformedToNeutral() {
        return this.transformedToNeutral;
    }

    @Override
    public final void setTransformedToNeutral(boolean neutral) {
        this.transformedToNeutral =neutral;
    }

    @Override
    public final @NotNull String getKey() {
        return key;
    }

    @NotNull
    @Override
    public final UUID getPlayerUUID(){
        return uuid;
    }

    @Override
    public final boolean isKey(@NotNull String s) {
        return s.equals(this.getKey());
    }

    @Override
    public final @NotNull Camp getCamp() {

        if(this.isNeutral()){
            return Camp.NEUTRAL;
        }

        if(this.isWereWolf()){
            return Camp.WEREWOLF;
        }
        return Camp.VILLAGER;
    }

    @Override
    public final boolean isCamp(@NotNull Camp camp) {
        return camp.equals(this.getCamp());
    }

    @Override
    public final IRole publicClone() {
        try {
            return (IRole) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @EventHandler
    public void onModeratorScoreBoard(UpdateModeratorNameTag event){

        StringBuilder sb = new StringBuilder(event.getPrefix());

        if(!this.uuid.equals(event.getPlayerUUID())) return;

        if(this.playerWW.isState(StatePlayer.DEATH)) return;

        if(this.isNeutral()){
            sb.append(ChatColor.GOLD);
        }
        else if(this.isWereWolf()){
            sb.append(ChatColor.DARK_RED);
        }
        else sb.append(ChatColor.GREEN);

        event.setPrefix(sb.toString());
        event.setSuffix(sb.toString());
    }

    @Override
    public void second() {
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onRequestWereWolfList(RequestSeeWereWolfListEvent event){

        if(!this.uuid.equals(event.getPlayerUUID())) return;

        if(this.playerWW.isState(StatePlayer.DEATH)) return;

        if (this.game.getConfig().getTimerValue(TimersBase.WEREWOLF_LIST.getKey()) <= 0) {
            event.setAccept(isWereWolf());
        }

    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onAppearInWereWolfList(AppearInWereWolfListEvent event){

        if(!this.uuid.equals(event.getPlayerUUID())) return;

        if(this.playerWW.isState(StatePlayer.DEATH)) return;

        event.setAppear(this.isWereWolf());
    }

    @EventHandler
    public void onNewWereWolf(NewWereWolfEvent event) {

        if(!this.playerWW.equals(event.getPlayerWW())) return;

        if(this.getPlayerWW().isState(StatePlayer.DEATH)) return;

        this.playerWW.sendMessageWithKey("werewolf.role.werewolf.go_to_the_werewolf_camp");
        Sound.WOLF_HOWL.play(getPlayerWW());
        this.recoverPotionEffect();

        this.game.getPlayerWW().stream()
                .filter(playerWW -> playerWW.getRole().isWereWolf())
                .filter(playerWW -> playerWW.isState(StatePlayer.ALIVE))
                .map(playerWW -> Bukkit.getPlayer(playerWW.getUUID()))
                .filter(Objects::nonNull)
                .forEach(player1 -> {
                    player1.sendMessage(game.translate("werewolf.role.werewolf.new_werewolf"));
                    Sound.WOLF_HOWL.play(player1);
                });
    }

    @Override
    public boolean isWereWolf() {
        return this.infected;
    }

    @Override
    public final boolean getInfected() {
        return this.infected;
    }

    @Override
    public final void setInfected() {
        this.infected = true;
    }

    @EventHandler
    public void onEndPlayerMessageInfected(EndPlayerMessageEvent event){

        if(!this.playerWW.equals(event.getPlayerWW())) return;

        StringBuilder sb = event.getEndMessage();

        if(this.infected){
            sb.append(game.translate("werewolf.end.infect"));
        }

        if(this.solitary){
            sb.append(game.translate("werewolf.end.solitary"));
        }

    }

    @Override
    public void recoverPotionEffect() {

        if(!this.isWereWolf()) return;

        this.playerWW.addPotionEffect(PotionEffectType.NIGHT_VISION);
        if(game.isDay(Day.DAY)) return;
        this.playerWW.addPotionEffect(PotionEffectType.INCREASE_DAMAGE);
    }

    @EventHandler
    public void onWWChat(WereWolfChatEvent event){
        if(event.isCancelled()) return;

        if(!this.getPlayerWW().isState(StatePlayer.ALIVE)) return;
        if(!this.isWereWolf()) return;

        this.getPlayerWW().sendMessageWithKey("werewolf.commands.admin.ww_chat.prefix",event.getMessage());

    }

    @EventHandler
    public void onChatSpeak(WereWolfCanSpeakInChatEvent event){

        if(!this.playerWW.equals(event.getPlayerWW())) return;

        if(!this.playerWW.isState(StatePlayer.ALIVE)) return;

        if(!this.isWereWolf()) return;

        event.setCanSpeak(true);

    }


    @EventHandler
    public void onCountCategories(CountRemainingRolesCategoriesEvent event){

        if (!this.playerWW.isState(StatePlayer.ALIVE)) return;

        if(this.isNeutral()){
            event.addNeutral();
            return;
        }

        if(this.isWereWolf()){
            event.addWerewolf();
            return;
        }

        event.addVillager();
    }

    @EventHandler
    public void onPlayerDeathByWereWolf(PlayerDeathEvent event) {

        if(!this.isWereWolf()) return;

        if(!this.getPlayerWW().isState(StatePlayer.ALIVE)) return;

        if(event.getEntity().getKiller()==null) return;

        Player killer = event.getEntity().getKiller();

        if(!this.uuid.equals(killer.getUniqueId())) return;

        killer.removePotionEffect(PotionEffectType.ABSORPTION);
        killer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 0, false, false));
        killer.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1200, 0, false, false));
    }



    @Override
    public final void roleAnnouncement(){

        Sound.EXPLODE.play(this.getPlayerWW());
        this.getPlayerWW().sendMessage(this.getDescription());
        this.getPlayerWW().sendMessageWithKey("werewolf.announcement.review_role");

        this.recoverPotionEffect();
        this.recoverPower();

        if(this.game.getConfig().isTrollSV()) return;

        if(!this.game.getStuffs().getStuffRoles().containsKey(getKey())){
            Bukkit.getConsoleSender().sendMessage("[WereWolfPlugin] invalid addon structure");
            return;
        }

        for(ItemStack i:game.getStuffs().getStuffRoles().get(getKey())) {
            this.playerWW.addItem(i);
        }
    }

    @Override
    public final @NotNull IPlayerWW getPlayerWW() {
        return playerWW;
    }

    @Override
    public final void setPlayerWW(@NotNull IPlayerWW playerWW) {
        this.playerWW = playerWW;
        this.uuid= playerWW.getUUID();
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onNightForWereWolf(NightEvent event) {

        if(!this.getPlayerWW().isState(StatePlayer.ALIVE)){
            return;
        }

        if(!this.isWereWolf()) return;

        this.getPlayerWW().addPotionEffect(PotionEffectType.INCREASE_DAMAGE);

        if(!this.game.getConfig().isConfigActive(ConfigsBase.WEREWOLF_CHAT.getKey())) return;

        openWereWolfChat();

    }

    protected void openWereWolfChat(){
        this.getPlayerWW().sendMessageWithKey("werewolf.commands.admin.ww_chat.announce",
                Utils
                        .conversion(
                                this.game.getConfig()
                                        .getTimerValue(
                                                TimersBase.WEREWOLF_CHAT_DURATION
                                                        .getKey())),
                this.game.getConfig().getWereWolfChatMaxMessage());

        Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) this.main,
                () -> {
                    if(!this.game.isState(StateGame.END)){
                        getPlayerWW()
                                .sendMessageWithKey("werewolf.commands.admin.ww_chat.disable");
                    }
                },
                this.game.getConfig().getTimerValue(TimersBase.WEREWOLF_CHAT_DURATION.getKey())* 20L);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onDayForWereWolf(DayEvent event) {

        if(!this.isWereWolf()) return;

        if(!this.getPlayerWW().isState(StatePlayer.ALIVE)){
            return;
        }

        this.getPlayerWW().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);

    }

    @Override
    public void setSolitary(boolean solitary) {
        this.solitary=solitary;
    }

    @Override
    public boolean isSolitary() {
        return solitary;
    }

    @EventHandler
    public void onDetectVictoryNeutral(WinConditionsCheckEvent event) {

        if(!this.isNeutral()) return;

        if (event.isCancelled()) return;

        if (!this.getPlayerWW().isState(StatePlayer.ALIVE)) return;

        if (this.game.getScore().getPlayerSize() != 1) return;

        event.setCancelled(true);

        event.setVictoryTeam(getKey());
    }
    @Override
    public String getDeathRole(){
        return this.deathRole.isEmpty()?this.getKey():this.deathRole;
    }


    @Override
    public void setDeathRole(String role){
        this.deathRole=role;
    }
}