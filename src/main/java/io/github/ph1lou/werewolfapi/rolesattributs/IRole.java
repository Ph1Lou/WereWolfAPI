package io.github.ph1lou.werewolfapi.rolesattributs;


import io.github.ph1lou.werewolfapi.IPlayerWW;
import io.github.ph1lou.werewolfapi.enums.Camp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface IRole {

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

    void setSolitary(boolean solitary);

    boolean isSolitary();

    void recoverPotionEffect();

    boolean isWereWolf();

    boolean getInfected();

    boolean isTransformedToNeutral();

    void setTransformedToNeutral(boolean neutral);

    boolean isNeutral();

    void setInfected();

    @Nullable
    IRole publicClone();

    void roleAnnouncement();

    @NotNull
    IPlayerWW getPlayerWW();

    void setPlayerWW(@NotNull IPlayerWW playerWW);

    String getDeathRole();

    void setDeathRole(String role);

}
