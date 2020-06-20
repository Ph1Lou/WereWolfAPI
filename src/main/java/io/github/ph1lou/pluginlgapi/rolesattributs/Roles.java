package io.github.ph1lou.pluginlgapi.rolesattributs;


import com.sun.org.apache.xpath.internal.operations.Bool;
import io.github.ph1lou.pluginlgapi.enumlg.Camp;

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
