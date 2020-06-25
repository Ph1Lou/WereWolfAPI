package io.github.ph1lou.pluginlgapi.rolesattributs;

import io.github.ph1lou.pluginlgapi.GetWereWolfAPI;
import io.github.ph1lou.pluginlgapi.WereWolfAPI;
import org.bukkit.entity.Player;

import java.util.UUID;

public abstract class RolesNeutral extends RolesImpl {

    public RolesNeutral(GetWereWolfAPI main, WereWolfAPI game, UUID uuid) {
        super(main,game, uuid);
    }

    @Override
    public boolean isNeutral() {
        return !isWereWolf();
    }
}
