package io.github.ph1lou.werewolfapi.rolesattributs;


import io.github.ph1lou.werewolfapi.PlayerWW;
import io.github.ph1lou.werewolfapi.enums.Camp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface Roles {

    @NotNull
    String getDescription();

    @NotNull
    String getKey();

    String getBetterDescription();

    boolean isKey(@NotNull String key);

    boolean isCamp(@NotNull Camp camp);

    @NotNull
    Camp getCamp();

    @NotNull
    UUID getPlayerUUID();

    void recoverPower();

    void recoverPotionEffect();

    boolean isWereWolf();

    boolean getInfected();

    boolean isTransformedToNeutral();

    void setTransformedToNeutral(boolean neutral);

    boolean isNeutral();

    void setInfected();

    @Nullable
    Roles publicClone();

    void roleAnnouncement();

    @NotNull
    PlayerWW getPlayerWW();

    void setPlayerWW(@NotNull PlayerWW playerWW);

}
