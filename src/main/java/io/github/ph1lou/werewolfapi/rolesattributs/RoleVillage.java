package io.github.ph1lou.werewolfapi.rolesattributs;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import io.github.ph1lou.werewolfapi.WereWolfAPI;

public abstract class RoleVillage extends Role {

    public RoleVillage(WereWolfAPI game, IPlayerWW playerWW, String key){
        super(game, playerWW,key);
    }

}
