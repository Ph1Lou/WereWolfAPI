package io.github.ph1lou.werewolfapi.rolesattributs;

import io.github.ph1lou.werewolfapi.GetWereWolfAPI;
import io.github.ph1lou.werewolfapi.IPlayerWW;

public abstract class RoleNeutral extends Role {

    public RoleNeutral(GetWereWolfAPI main, IPlayerWW playerWW, String key){
        super(main, playerWW,key);
    }

    @Override
    public boolean isNeutral() {
        return !super.isWereWolf();
    }


}