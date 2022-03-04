package fr.ph1lou.werewolfapi.role.interfaces;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;

import java.util.List;

public interface IAffectedPlayers {

    void addAffectedPlayer(IPlayerWW playerWW);

    void removeAffectedPlayer(IPlayerWW playerWW);

    void clearAffectedPlayer();

    List<? extends IPlayerWW> getAffectedPlayers();

}
