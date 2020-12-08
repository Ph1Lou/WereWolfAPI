package io.github.ph1lou.werewolfapi.rolesattributs;

import io.github.ph1lou.werewolfapi.GetWereWolfAPI;
import io.github.ph1lou.werewolfapi.PlayerWW;
import io.github.ph1lou.werewolfapi.enumlg.StatePlayer;
import io.github.ph1lou.werewolfapi.events.WinConditionsCheckEvent;
import org.bukkit.event.EventHandler;

public abstract class RolesNeutral extends RolesImpl {

    public RolesNeutral(GetWereWolfAPI main, PlayerWW playerWW, String key){
        super(main,playerWW,key);
    }

    @Override
    public boolean isNeutral() {
        return !isWereWolf();
    }

    @EventHandler
    public void onDetectVictoryNeutral(WinConditionsCheckEvent event) {

        if (event.isCancelled()) return;

        if (!getPlayerWW().isState(StatePlayer.ALIVE)) return;

        if (game.getScore().getPlayerSize() != 1) return;

        event.setCancelled(true);

        event.setVictoryTeam(getKey());
    }
}