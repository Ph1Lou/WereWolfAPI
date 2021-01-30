package io.github.ph1lou.werewolfapi.rolesattributs;

import io.github.ph1lou.werewolfapi.GetWereWolfAPI;
import io.github.ph1lou.werewolfapi.PlayerWW;

public abstract class RolesNeutral extends RolesImpl {

    public RolesNeutral(GetWereWolfAPI main, PlayerWW playerWW, String key){
        super(main,playerWW,key);
    }

    @Override
    public boolean isNeutral() {
        return !super.isWereWolf();
    }


}