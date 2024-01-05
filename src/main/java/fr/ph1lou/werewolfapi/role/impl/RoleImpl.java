package fr.ph1lou.werewolfapi.role.impl;

import fr.ph1lou.werewolfapi.annotations.Role;
import fr.ph1lou.werewolfapi.basekeys.RoleBase;
import fr.ph1lou.werewolfapi.enums.Aura;
import fr.ph1lou.werewolfapi.enums.Camp;
import fr.ph1lou.werewolfapi.enums.Day;
import fr.ph1lou.werewolfapi.enums.StatePlayer;
import fr.ph1lou.werewolfapi.events.UpdateNameTagEvent;
import fr.ph1lou.werewolfapi.events.game.utils.EndPlayerMessageEvent;
import fr.ph1lou.werewolfapi.game.WereWolfAPI;
import fr.ph1lou.werewolfapi.player.impl.PotionModifier;
import fr.ph1lou.werewolfapi.player.interfaces.IAuraModifier;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import fr.ph1lou.werewolfapi.role.interfaces.IDisplay;
import fr.ph1lou.werewolfapi.role.interfaces.IRole;
import fr.ph1lou.werewolfapi.role.interfaces.IRoleExtended;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public abstract class RoleImpl implements IRole, IRoleExtended, Cloneable, IDisplay {

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
    public Set<IPlayerWW> getPlayersMet() {
        return this.getPlayerWW().getPlayersMet();
    }

    @Override
    public boolean isNeutral() {
        return this.solitary || this.transformedToNeutral;
    }

    @Override
    public final boolean isTransformedToVillager() {
        return this.transformedToVillager;
    }

    @Override
    public final void setTransformedToVillager(boolean villager) {
        this.transformedToVillager = villager;
        Bukkit.getPluginManager().callEvent(new UpdateNameTagEvent(this.getPlayerWW()));
    }

    @Override
    public final boolean isTransformedToNeutral() {
        return this.transformedToNeutral;
    }

    @Override
    public final void setTransformedToNeutral(boolean neutral) {
        this.transformedToNeutral = neutral;
        Bukkit.getPluginManager().callEvent(new UpdateNameTagEvent(this.getPlayerWW()));
    }

    @Override
    public final @NotNull String getKey() {

        Role role = this.getClass().getAnnotation(Role.class);

        if (role == null) {
            Bukkit.getLogger().severe(String.format("The class %s has not been annotated by the role annotation",
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

    @Override
    public void second() {
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
        Bukkit.getPluginManager().callEvent(new UpdateNameTagEvent(this.getPlayerWW()));
    }

    @Override
    public final void setInfected() {
        this.setInfected(true);
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

    @Override
    public final @NotNull IPlayerWW getPlayerWW() {
        return playerWW;
    }

    @Override
    public final void setPlayerWW(@NotNull IPlayerWW playerWW) {
        this.playerWW = playerWW;
        this.uuid = playerWW.getUUID();
    }


    @Override
    public final boolean isSolitary() {
        return solitary;
    }

    @Override
    public final void setSolitary(boolean solitary) {
        this.solitary = solitary;
        Bukkit.getPluginManager().callEvent(new UpdateNameTagEvent(this.getPlayerWW()));
    }

    @Override
    public final boolean isDisplayCamp(String camp) {
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
    public final void setDisplayCamp(@Nullable String camp) {
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
    public final void setDisplayRole(@Nullable String key) {
        this.displayRole = key;
    }

    @Override
    public Aura getAura() {
        return auraModifiers.isEmpty() ? getDefaultAura() : auraModifiers.get(auraModifiers.size() - 1).getAura();
    }

    @Override
    public final void clearDisplay() {
        this.displayCamp = null;
        this.displayRole = null;
    }

    @Override
    public final Aura getDefaultAura() {
        Role role = this.getClass().getAnnotation(Role.class);

        if (role == null) {
            Bukkit.getLogger().severe(String.format("The class %s has not been annotated by the role annotation",
                    this.getClass().getName()));
            return Aura.LIGHT;
        }
        return role.defaultAura();
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