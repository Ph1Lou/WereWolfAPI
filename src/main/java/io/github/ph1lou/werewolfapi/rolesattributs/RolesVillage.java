package io.github.ph1lou.werewolfapi.rolesattributs;

import io.github.ph1lou.werewolfapi.GetWereWolfAPI;
import io.github.ph1lou.werewolfapi.WereWolfAPI;

import java.util.UUID;

public abstract class RolesVillage extends RolesImpl {

    public RolesVillage(GetWereWolfAPI main, WereWolfAPI game, UUID uuid, String key) {
        super(main,game, uuid, key);
    }

    @Override
    public boolean isNeutral() {
        return false;
    }
}
