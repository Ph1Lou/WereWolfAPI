package io.github.ph1lou.werewolfapi.rolesattributs;

import io.github.ph1lou.werewolfapi.GetWereWolfAPI;
import io.github.ph1lou.werewolfapi.WereWolfAPI;

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
