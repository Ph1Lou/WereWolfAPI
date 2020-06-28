package io.github.ph1lou.werewolfapi.rolesattributs;


import io.github.ph1lou.werewolfapi.enumlg.Camp;

import org.bukkit.entity.Player;

import java.util.UUID;

public interface Roles {

    String getDescription();

    String getDisplay();

    boolean isDisplay(String key);

    boolean isCamp(Camp camp);

    Camp getCamp();

    UUID getPlayerUUID();

    void setPlayerUUID(UUID uuid);

    void stolen(UUID uuid);

    Player recoverPower();

    void recoverPotionEffect(Player player);

    boolean isWereWolf();

    boolean getInfected();

    boolean isNeutral();

    void setInfected(Boolean infected);

    Roles publicClone();

}
