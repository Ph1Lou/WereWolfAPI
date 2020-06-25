package io.github.ph1lou.pluginlgapi.rolesattributs;

import io.github.ph1lou.pluginlgapi.GetWereWolfAPI;
import io.github.ph1lou.pluginlgapi.WereWolfAPI;

import java.util.UUID;

public abstract class RolesVillage extends RolesImpl {

    public RolesVillage(GetWereWolfAPI main, WereWolfAPI game, UUID uuid) {
        super(main,game, uuid);
    }

    @Override
    public boolean isNeutral() {
        return false;
    }
}
