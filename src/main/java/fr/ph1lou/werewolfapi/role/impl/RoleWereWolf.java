package fr.ph1lou.werewolfapi.role.impl;

import fr.ph1lou.werewolfapi.game.WereWolfAPI;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;

public abstract class RoleWereWolf extends RoleImpl {


    public RoleWereWolf(WereWolfAPI game, IPlayerWW playerWW) {
        super(game, playerWW);
    }


    @Override
    public boolean isWereWolf() {
        return true;
    }
}
