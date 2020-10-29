package io.github.ph1lou.werewolfapi.rolesattributs;


import io.github.ph1lou.werewolfapi.enumlg.Camp;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface Roles {

    String getDescription();

    String getKey();

    boolean isKey(String key);

    boolean isCamp(@NotNull Camp camp);

    @NotNull
    Camp getCamp();

    UUID getPlayerUUID();

    void setPlayerUUID(@NotNull UUID uuid);

    void stolen(@NotNull UUID uuid);

    @Nullable
    Player recoverPower();

    void recoverPotionEffect(@NotNull Player player);

    boolean isWereWolf();

    boolean getInfected();

    boolean isNeutral();

    void setInfected(Boolean infected);

    Roles publicClone();

}
