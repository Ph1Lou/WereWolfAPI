package io.github.ph1lou.werewolfapi.rolesattributs;


import io.github.ph1lou.werewolfapi.enumlg.Camp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface Roles {

    @NotNull
    String getDescription();

    @NotNull
    String getKey();

    boolean isKey(@NotNull String key);

    boolean isCamp(@NotNull Camp camp);

    @NotNull
    Camp getCamp();

    @NotNull
    UUID getPlayerUUID();

    void setPlayerUUID(@NotNull UUID uuid);

    void recoverPowerAfterStolen();

    void recoverPower();

    void recoverPotionEffect();

    boolean isWereWolf();

    boolean getInfected();

    boolean isNeutral();

    void setInfected();

    @Nullable
    Roles publicClone();

}
