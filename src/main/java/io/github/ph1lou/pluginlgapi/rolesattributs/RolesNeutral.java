package io.github.ph1lou.pluginlgapi.rolesattributs;

import io.github.ph1lou.pluginlgapi.GetWereWolfAPI;
import io.github.ph1lou.pluginlgapi.WereWolfAPI;
import io.github.ph1lou.pluginlgapi.enumlg.Camp;
import io.github.ph1lou.pluginlgapi.rolesattributs.RolesImpl;
import org.bukkit.entity.Player;

import java.util.UUID;

public abstract class RolesNeutral extends RolesImpl {

    public RolesNeutral(GetWereWolfAPI main, WereWolfAPI game, UUID uuid) {
        super(main,game, uuid);
        this.setCamp(Camp.NEUTRAL);
    }

    @Override
    public void recoverPotionEffect(Player player) {
        super.recoverPotionEffect(player);
    }

    @Override
    public void recoverPower(Player player) {
    }

}
