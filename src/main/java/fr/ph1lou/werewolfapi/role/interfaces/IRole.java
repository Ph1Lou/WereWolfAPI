package fr.ph1lou.werewolfapi.role.interfaces;


import fr.ph1lou.werewolfapi.enums.Camp;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;
import java.util.UUID;

@SuppressWarnings("EmptyMethod")
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

    void recoverPotionEffects();

    @Nullable
    IRole publicClone();

    @NotNull
    IPlayerWW getPlayerWW();

    void setPlayerWW(@NotNull IPlayerWW playerWW);

    void disableAbilities();

    void enableAbilities();

    boolean isAbilityEnabled();

    Set<IPlayerWW> getPlayersMet();
}
