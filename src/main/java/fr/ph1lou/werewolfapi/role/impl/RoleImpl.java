package fr.ph1lou.werewolfapi.role.impl;

import fr.ph1lou.werewolfapi.annotations.Role;
import fr.ph1lou.werewolfapi.basekeys.ConfigBase;
import fr.ph1lou.werewolfapi.basekeys.IntValueBase;
import fr.ph1lou.werewolfapi.basekeys.Prefix;
import fr.ph1lou.werewolfapi.basekeys.RoleBase;
import fr.ph1lou.werewolfapi.basekeys.TimerBase;
import fr.ph1lou.werewolfapi.enums.Aura;
import fr.ph1lou.werewolfapi.enums.Camp;
import fr.ph1lou.werewolfapi.enums.Day;
import fr.ph1lou.werewolfapi.enums.Sound;
import fr.ph1lou.werewolfapi.enums.StatePlayer;
import fr.ph1lou.werewolfapi.events.UpdateNameTagEvent;
import fr.ph1lou.werewolfapi.events.game.day_cycle.DayEvent;
import fr.ph1lou.werewolfapi.events.game.day_cycle.NightEvent;
import fr.ph1lou.werewolfapi.events.game.permissions.UpdateModeratorNameTagEvent;
import fr.ph1lou.werewolfapi.events.game.utils.EndPlayerMessageEvent;
import fr.ph1lou.werewolfapi.events.game.utils.WinConditionsCheckEvent;
import fr.ph1lou.werewolfapi.events.werewolf.AppearInWereWolfListEvent;
import fr.ph1lou.werewolfapi.events.werewolf.NewWereWolfEvent;
import fr.ph1lou.werewolfapi.events.werewolf.RequestSeeWereWolfListEvent;
import fr.ph1lou.werewolfapi.events.werewolf.WereWolfCanSpeakInChatEvent;
import fr.ph1lou.werewolfapi.events.werewolf.WereWolfChatEvent;
import fr.ph1lou.werewolfapi.events.werewolf.WereWolfKillEvent;
import fr.ph1lou.werewolfapi.game.WereWolfAPI;
import fr.ph1lou.werewolfapi.player.impl.PotionModifier;
import fr.ph1lou.werewolfapi.player.interfaces.IAuraModifier;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import fr.ph1lou.werewolfapi.player.utils.Formatter;
import fr.ph1lou.werewolfapi.role.interfaces.IDisplay;
import fr.ph1lou.werewolfapi.role.interfaces.IRole;
import fr.ph1lou.werewolfapi.utils.BukkitUtils;
import fr.ph1lou.werewolfapi.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public abstract class RoleImpl implements IRole, Cloneable, IDisplay {

    protected final WereWolfAPI game;
    private final List<IAuraModifier> auraModifiers = new ArrayList<>();
    @NotNull
    private UUID uuid;
    private boolean infected = false;
    private boolean transformedToNeutral = false;
    private boolean transformedToVillager = false;
    private boolean solitary = false;
    @NotNull
    private IPlayerWW playerWW;
    @Nullable
    private String displayRole;
    @Nullable
    private String displayCamp;
    private boolean abilityEnabled = true;

    public RoleImpl(@NotNull WereWolfAPI game, @NotNull IPlayerWW playerWW) {
        this.game = game;
        this.uuid = playerWW.getUUID();
        this.playerWW = playerWW;
    }

    @Override
    public boolean isNeutral() {
        return this.solitary || this.transformedToNeutral;
    }

    @Override
    public boolean isTransformedToVillager() {
        return this.transformedToVillager;
    }

    @Override
    public void setTransformedToVillager(boolean villager) {
        this.transformedToVillager = villager;
    }

    @Override
    public final boolean isTransformedToNeutral() {
        return this.transformedToNeutral;
    }

    @Override
    public final void setTransformedToNeutral(boolean neutral) {
        this.transformedToNeutral = neutral;
    }

    @Override
    public final @NotNull String getKey() {

        Role role = this.getClass().getAnnotation(Role.class);

        if (role == null) {
            Bukkit.getLogger().warning(String.format("The class %s has not been annotated by the role annotation",
                    this.getClass().getName()));
            return this.getClass().getName();
        }
        return role.key();
    }

    @NotNull
    @Override
    public final UUID getPlayerUUID() {
        return this.uuid;
    }

    @Override
    public final boolean isKey(@NotNull String s) {
        return s.equals(this.getKey());
    }

    @Override
    public final @NotNull Camp getCamp() {

        if (this.isNeutral()) {
            return Camp.NEUTRAL;
        }

        if (this.isWereWolf()) {
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
    public final void onModeratorScoreBoard(UpdateModeratorNameTagEvent event) {

        StringBuilder sb = new StringBuilder(event.getPrefix());

        if (!this.uuid.equals(event.getPlayerUUID())) return;

        if (this.playerWW.isState(StatePlayer.DEATH)) return;

        if (this.isNeutral()) {
            sb.append(ChatColor.GOLD);
        } else if (this.isWereWolf()) {
            sb.append(ChatColor.DARK_RED);
        } else sb.append(ChatColor.GREEN);

        event.setPrefix(sb.toString());
        event.setSuffix(sb.toString());
    }

    @Override
    public void second() {
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onRequestWereWolfList(RequestSeeWereWolfListEvent event) {

        if (!this.uuid.equals(event.getPlayerUUID())) return;

        if (this.playerWW.isState(StatePlayer.DEATH)) return;

        if (this.game.getConfig().getTimerValue(TimerBase.WEREWOLF_LIST) <= 0) {
            event.setAccept(isWereWolf());
        }

    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onAppearInWereWolfList(AppearInWereWolfListEvent event) {

        if (!this.uuid.equals(event.getPlayerUUID())) return;

        if (this.playerWW.isState(StatePlayer.DEATH)) return;

        event.setAppear(this.isWereWolf());
    }

    @EventHandler
    public void onNewWereWolf(NewWereWolfEvent event) {

        if (!this.playerWW.equals(event.getPlayerWW())) return;

        if (this.getPlayerWW().isState(StatePlayer.DEATH)) return;

        Bukkit.getPluginManager().callEvent(new UpdateNameTagEvent(this.getPlayerWW()));

        if (this.isWereWolf()) { // Envoie le message seulement si vraiment loup
            this.playerWW.sendMessageWithKey(Prefix.YELLOW, "werewolf.roles.werewolf.go_to_the_werewolf_camp");
            Sound.WOLF_HOWL.play(getPlayerWW());
            this.recoverPotionEffects();
        }

        this.game.getPlayersWW().stream()
                .filter(playerWW -> playerWW.getRole().isWereWolf())
                .filter(playerWW -> playerWW.isState(StatePlayer.ALIVE))
                .forEach(player1 -> {
                    player1.sendMessageWithKey(Prefix.RED, "werewolf.roles.werewolf.new_werewolf");
                    Sound.WOLF_HOWL.play(player1);
                });
    }

    @Override
    public boolean isWereWolf() {
        return this.infected;
    }

    @Override
    public final boolean isInfected() {
        return this.infected;
    }

    @Override
    public final void setInfected(boolean infected) {
        this.infected = infected;
    }

    @Override
    public final void setInfected() {
        this.infected = true;
    }

    @EventHandler
    public final void onEndPlayerMessageInfected(EndPlayerMessageEvent event) {

        if (!this.playerWW.equals(event.getPlayerWW())) return;

        StringBuilder sb = event.getEndMessage();

        if (this.infected) {
            sb.append(game.translate("werewolf.end.infect"));
        }

        if (this.solitary) {
            sb.append(game.translate("werewolf.end.solitary"));
        }
    }

    @Override
    public void recoverPotionEffect() {
    }

    @Override
    public final void recoverPotionEffects() {

        this.recoverPotionEffect();
        if (!this.isAbilityEnabled()) return;

        if (!this.isWereWolf()) return;

        this.playerWW.addPotionModifier(PotionModifier.add(PotionEffectType.NIGHT_VISION, RoleBase.WEREWOLF));
        if (game.isDay(Day.DAY)) return;
        this.playerWW.addPotionModifier(PotionModifier.add(PotionEffectType.INCREASE_DAMAGE, RoleBase.WEREWOLF));
    }

    @EventHandler
    public void onWWChat(WereWolfChatEvent event) {

        if (event.isCancelled()) return;
        if (!this.isAbilityEnabled()) return;
        if (!this.getPlayerWW().isState(StatePlayer.ALIVE)) return;
        if (!this.isWereWolf()) return;

        event.sendMessage(this.getPlayerWW());
    }

    @EventHandler
    public void onChatSpeak(WereWolfCanSpeakInChatEvent event) {

        if (!this.isAbilityEnabled()) return;

        if (!this.playerWW.equals(event.getPlayerWW())) return;

        if (!this.playerWW.isState(StatePlayer.ALIVE)) return;

        if (!this.isWereWolf()) return;

        event.setCanSpeak(true);
    }

    @EventHandler
    public void onPlayerDeathByWereWolf(PlayerDeathEvent event) {

        if (!this.isWereWolf()) return;

        if (!this.isAbilityEnabled()) return;

        if (event.getEntity().getKiller() == null) return;

        Player killer = event.getEntity().getKiller();

        if (!this.uuid.equals(killer.getUniqueId())) return;

        Player victim = event.getEntity().getPlayer();

        if (victim == null) return;

        Optional<IPlayerWW> victimWW = game.getPlayerWW(victim.getUniqueId());
        if (victimWW.isPresent()) {
            WereWolfKillEvent killEvent = new WereWolfKillEvent(this.getPlayerWW(), victimWW.get());
            Bukkit.getPluginManager().callEvent(killEvent);
            if (killEvent.isCancelled()) {
                return;
            }
        }
        this.getPlayerWW().addPotionModifier(PotionModifier.add(PotionEffectType.SPEED, 1200, 0, RoleBase.WEREWOLF));
        this.getPlayerWW().addPotionModifier(PotionModifier.add(PotionEffectType.ABSORPTION, 1200, 0, RoleBase.WEREWOLF));
    }


    @Override
    public final void roleAnnouncement() {

        Sound.EXPLODE.play(this.getPlayerWW());
        this.getPlayerWW().sendMessageWithKey("werewolf.description.description_message",
                Formatter.format("&description&", this.getDescription()));
        this.getPlayerWW().sendMessageWithKey(Prefix.YELLOW, "werewolf.announcement.review_role");

        this.recoverPotionEffects();
        this.recoverPower();

        if (this.game.getConfig().isConfigActive(ConfigBase.TROLL_ROLE)) return;

        for (ItemStack i : game.getStuffs().getStuffRole(this.getKey())) {
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
        this.uuid = playerWW.getUUID();
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onNightForWereWolf(NightEvent event) {

        if (!this.isWereWolf()) return;

        if (!this.isAbilityEnabled()) return;

        this.getPlayerWW().addPotionModifier(PotionModifier.add(PotionEffectType.INCREASE_DAMAGE, RoleBase.WEREWOLF));

        if (!this.game.getConfig().isConfigActive(ConfigBase.WEREWOLF_CHAT)) return;

        openWereWolfChat();

    }

    protected void openWereWolfChat() {
        this.getPlayerWW().sendMessageWithKey(Prefix.RED, "werewolf.commands.player.ww_chat.announce",
                Formatter.format("&timer&", Utils.conversion(game.getConfig()
                        .getTimerValue(TimerBase.WEREWOLF_CHAT_DURATION))),
                Formatter.format("&number&", game.getConfig().getValue(IntValueBase.WEREWOLF_CHAT)));

        BukkitUtils.scheduleSyncDelayedTask(game,
                () -> getPlayerWW()
                        .sendMessageWithKey(Prefix.RED, "werewolf.commands.player.ww_chat.disable"),
                this.game.getConfig().getTimerValue(TimerBase.WEREWOLF_CHAT_DURATION) * 20L);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onDayForWereWolf(DayEvent event) {

        if (!this.isWereWolf()) return;

        this.getPlayerWW().addPotionModifier(PotionModifier.remove(PotionEffectType.INCREASE_DAMAGE, RoleBase.WEREWOLF, 0));

    }

    @Override
    public boolean isSolitary() {
        return solitary;
    }

    @Override
    public void setSolitary(boolean solitary) {
        this.solitary = solitary;
    }

    @EventHandler
    public void onDetectVictoryNeutral(WinConditionsCheckEvent event) {

        if (!this.isNeutral()) return;

        if (event.isCancelled()) return;

        if (!this.getPlayerWW().isState(StatePlayer.ALIVE)) return;

        if (this.game.getPlayersCount() != 1) return;

        event.setCancelled(true);

        event.setVictoryTeam(this.getKey());
    }

    @Override
    public boolean isDisplayCamp(String camp) {
        return this.getDisplayCamp().equals(camp);
    }

    @Override
    public String getDisplayCamp() {
        if (this.displayCamp != null) {
            return this.displayCamp;
        }
        return this.getCamp().getKey();
    }

    @Override
    public void setDisplayCamp(@Nullable String camp) {
        this.displayCamp = camp;
    }

    @Override
    public String getDisplayRole() {
        if (this.displayRole != null) {
            return this.displayRole;
        }
        return this.getKey();
    }

    @Override
    public void setDisplayRole(@Nullable String key) {
        this.displayRole = key;
    }

    @Override
    public Aura getAura() {
        return auraModifiers.isEmpty() ? getDefaultAura() : auraModifiers.get(auraModifiers.size() - 1).getAura();
    }

    @Override
    public void clearDisplay() {
        this.displayCamp = null;
        this.displayRole = null;
    }

    @Override
    public void addAuraModifier(IAuraModifier auraModifier) {
        removeAuraModifier(auraModifier.getName());
        auraModifiers.add(auraModifier);
        auraModifiers.sort(null);
    }

    @Override
    public void removeAuraModifier(IAuraModifier auraModifier) {
        auraModifiers.remove(auraModifier);
    }

    @Override
    public void removeAuraModifier(String modifierName) {
        auraModifiers.removeAll(auraModifiers.stream()
                .filter(a -> a.getName().equals(modifierName)).collect(Collectors.toList()));
    }

    @Override
    public void removeTemporaryAuras() {
        auraModifiers.removeAll(auraModifiers.stream().filter(IAuraModifier::isTemporary).collect(Collectors.toList()));
    }

    @Override
    public List<IAuraModifier> getAuraModifiers() {
        return auraModifiers;
    }

    @Override
    public final void disableAbilities() {
        this.abilityEnabled = false;

        this.disableAbilitiesRole();

        if (!this.isWereWolf()) return;

        if (!this.getPlayerWW().isState(StatePlayer.ALIVE)) {
            return;
        }

        this.getPlayerWW()
                .addPotionModifier(PotionModifier.remove(PotionEffectType.INCREASE_DAMAGE, RoleBase.WEREWOLF, 0));
    }

    @Override
    public final void enableAbilities() {
        this.abilityEnabled = true;

        this.recoverPotionEffects();

        this.enableAbilitiesRole();
    }

    @Override
    public void disableAbilitiesRole() {

    }

    @Override
    public void enableAbilitiesRole() {

    }

    @Override
    public boolean isAbilityEnabled() {
        return this.abilityEnabled;
    }
}