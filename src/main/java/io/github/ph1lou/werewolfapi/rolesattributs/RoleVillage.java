package io.github.ph1lou.werewolfapi.rolesattributs;

import io.github.ph1lou.werewolfapi.GetWereWolfAPI;
import io.github.ph1lou.werewolfapi.IPlayerWW;

public abstract class RoleVillage extends Role {

    public RoleVillage(GetWereWolfAPI main, IPlayerWW playerWW, String key){
        super(main, playerWW,key);
    }

}
