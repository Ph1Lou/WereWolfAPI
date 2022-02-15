package fr.ph1lou.werewolfapi.role.interfaces;


import fr.ph1lou.werewolfapi.enums.Camp;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface IRole extends IDisplay, IAura, ICamp, Listener {

    @NotNull
    String getDescription();

    @NotNull
    String getKey();

    boolean isKey(@NotNull String key);

    boolean isCamp(@NotNull Camp camp);

    void second();

    @NotNull
    Camp getCamp();

    @NotNull
    UUID getPlayerUUID();

    void recoverPower();

    void recoverPotionEffect();

    void recoverPotionEffects();

    @Nullable
    IRole publicClone();

    void roleAnnouncement();

    @NotNull
    IPlayerWW getPlayerWW();

    void setPlayerWW(@NotNull IPlayerWW playerWW);

    String getDeathRole();

    void setDeathRole(String role);

    void disableAbilities();

    void enableAbilities();

    void disableAbilitiesRole();

    void enableAbilitiesRole();

    boolean isAbilityEnabled();
}
