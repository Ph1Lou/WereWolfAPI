package fr.ph1lou.werewolfapi.role.impl;

import fr.ph1lou.werewolfapi.game.WereWolfAPI;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;

public abstract class RoleNeutral extends RoleImpl {

    public RoleNeutral(WereWolfAPI game, IPlayerWW playerWW) {
        super(game, playerWW);
    }

    @Override
    public boolean isNeutral() {
        return !this.isWereWolf() && !this.isTransformedToVillager();
    }
}