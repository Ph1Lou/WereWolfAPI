package io.github.ph1lou.werewolfapi.rolesattributs;

import io.github.ph1lou.werewolfapi.PlayerWW;

import java.util.List;

public interface AffectedPlayers {

    void addAffectedPlayer(PlayerWW playerWW);

    void removeAffectedPlayer(PlayerWW playerWW);

    void clearAffectedPlayer();

    List<PlayerWW> getAffectedPlayers();

}
