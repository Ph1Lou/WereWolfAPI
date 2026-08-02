package fr.ph1lou.werewolfapi.vote;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;

public interface IUrnVoteManager {
    boolean isActive();

    /**
     * Mark a player so that their ballot cast during the given urn-vote session
     * is consumed but NOT counted at dépouillement (Raven penalty).
     */
    void markBallotDiscarded(IPlayerWW player, int session);
}
