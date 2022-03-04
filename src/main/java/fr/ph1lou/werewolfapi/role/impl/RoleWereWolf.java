package fr.ph1lou.werewolfapi.role.impl;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import fr.ph1lou.werewolfapi.game.WereWolfAPI;
import fr.ph1lou.werewolfapi.enums.Aura;

public abstract class RoleWereWolf extends Role {


    public RoleWereWolf(WereWolfAPI game, IPlayerWW playerWW, String key){
        super(game, playerWW,key);
    }


    @Override
    public boolean isWereWolf() {
        return true;
    }

    @Override
    public Aura getDefaultAura() {
        return Aura.DARK;
    }

}
