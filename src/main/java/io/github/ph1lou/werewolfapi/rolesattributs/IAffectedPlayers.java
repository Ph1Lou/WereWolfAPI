package io.github.ph1lou.werewolfapi.rolesattributs;

import io.github.ph1lou.werewolfapi.IPlayerWW;

import java.util.List;

public interface IAffectedPlayers {

    void addAffectedPlayer(IPlayerWW playerWW);

    void removeAffectedPlayer(IPlayerWW playerWW);

    void clearAffectedPlayer();

    List<? extends IPlayerWW> getAffectedPlayers();

}
