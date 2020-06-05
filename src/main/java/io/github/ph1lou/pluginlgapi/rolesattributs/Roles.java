package io.github.ph1lou.pluginlgapi.rolesattributs;


import com.sun.org.apache.xpath.internal.operations.Bool;
import io.github.ph1lou.pluginlgapi.enumlg.Camp;

import org.bukkit.entity.Player;

import java.util.UUID;

public interface Roles {

    void setCamp(Camp camp);

    boolean isCamp(Camp camp);

    Camp getCamp();

    String getDescription();

    String getDisplay();

    Boolean isDisplay(String key);

    UUID getPlayerUUID();

    void setPlayerUUID(UUID uuid);

    void stolen(UUID uuid);

    void recoverPower(Player player);

    void recoverPotionEffect(Player player);

    boolean isWereWolf();

    Boolean getInfected();


    void setInfected(Boolean infected);

    Roles publicClone();

}
