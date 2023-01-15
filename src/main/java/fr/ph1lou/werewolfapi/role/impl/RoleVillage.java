package fr.ph1lou.werewolfapi.role.impl;

import fr.ph1lou.werewolfapi.enums.Aura;
import fr.ph1lou.werewolfapi.game.WereWolfAPI;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;

public abstract class RoleVillage extends RoleImpl {

    public RoleVillage(WereWolfAPI game, IPlayerWW playerWW) {
        super(game, playerWW);
    }

    @Override
    public Aura getDefaultAura() {
        return Aura.LIGHT;
    }
}
