package fr.ph1lou.werewolfapi.vote;

import fr.ph1lou.werewolfapi.enums.VoteStatus;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;

import java.util.Map;
import java.util.Optional;

public interface IVoteManager {

    /**
     * Add a vote to voteWW by voterWW
     * @param voterWW the voter
     * @param voteWW the player who received vote
     */
    void setOneVote(IPlayerWW voterWW, IPlayerWW voteWW);

    /**
     * Reset Vote
     */
    void resetVote();

    /**
     * Get Players Vote
     * @return vote count for each player (in new vote system return only villager vote)
     */
    Map<IPlayerWW,Integer> getVotes();

    /**
     * Get Players Vote
     * @return vote for each player
     */
    Map<IPlayerWW, IPlayerWW> getPlayerVotes();

    /**
     * Get Player who have the largest amount of vote
     * @return PlayerWW (if new vote return player most voted by villager)
     */
    Optional<IPlayerWW> getResult();


    /**
     * Check Vote Status
     */
    boolean isStatus(VoteStatus status);

    /**
     * Set Vote Status
     */
    void setStatus (VoteStatus status);

}
