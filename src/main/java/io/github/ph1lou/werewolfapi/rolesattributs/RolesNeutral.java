package io.github.ph1lou.werewolfapi.rolesattributs;

import io.github.ph1lou.werewolfapi.GetWereWolfAPI;
import io.github.ph1lou.werewolfapi.WereWolfAPI;
import io.github.ph1lou.werewolfapi.enumlg.StatePlayer;
import io.github.ph1lou.werewolfapi.events.WinConditionsCheckEvent;
import org.bukkit.event.EventHandler;

import java.util.Objects;
import java.util.UUID;

public abstract class RolesNeutral extends RolesImpl {

    public RolesNeutral(GetWereWolfAPI main, WereWolfAPI game, UUID uuid, String key) {
        super(main, game, uuid, key);
    }

    @Override
    public boolean isNeutral() {
        return !isWereWolf();
    }

    @EventHandler
    private void onDetectVictoryNeutral(WinConditionsCheckEvent event) {

        if (event.isCancelled()) return;

        if (!Objects.requireNonNull(
                game.getPlayerWW(
                        getPlayerUUID())).isState(StatePlayer.ALIVE)) return;

        if (game.getScore().getPlayerSize() != 1) return;

        event.setCancelled(true);

        event.setVictoryTeam(getKey());

    }
}