package fr.ph1lou.werewolfapi.role.impl;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import fr.ph1lou.werewolfapi.game.WereWolfAPI;
import fr.ph1lou.werewolfapi.basekeys.Prefix;
import fr.ph1lou.werewolfapi.enums.StatePlayer;
import fr.ph1lou.werewolfapi.events.roles.SelectionEndEvent;
import fr.ph1lou.werewolfapi.role.interfaces.IPower;
import org.bukkit.event.EventHandler;

public abstract class RoleWithLimitedSelectionDuration extends RoleVillage implements IPower {

    public RoleWithLimitedSelectionDuration(WereWolfAPI game, IPlayerWW playerWW, String key) {
        super(game, playerWW,key);
    }
    private boolean power=true;

    @EventHandler
    public void onSelectionEnd(SelectionEndEvent event) {

        if (!hasPower()) return;

        setPower(false);

        if(!getPlayerWW().isState(StatePlayer.ALIVE)){
            return;
        }

        getPlayerWW().sendMessageWithKey(Prefix.RED ,"werewolf.check.end_selection");
    }

    @Override
    public final void setPower(boolean power) {
        this.power=power;
    }

    @Override
    public final boolean hasPower() {
        return(this.power);
    }
}
