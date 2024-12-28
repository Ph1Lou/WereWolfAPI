package fr.ph1lou.werewolfapi.vote;

import fr.ph1lou.werewolfapi.enums.VoteStatus;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;

import java.util.Optional;
import java.util.Set;

public interface IVoteManager {

    /**
     * Add a vote to voteWW by voterWW
     *
     * @param voterWW the voter
     * @param voteWW  the player who received vote
     */
    void setOneVote(IPlayerWW voterWW, IPlayerWW voteWW);

    /**
     * Reset Vote
     */
    void resetVote();

    /**
     * Get Players Vote
     *
     * @return vote count for each player (in new vote system return only villager vote)
     */
    int getVotes(IPlayerWW playerWW);

    void setVotes(IPlayerWW playerWW, int value);

    /**
     * Get Players Vote
     *
     * @return vote for each player
     */
    Optional<IPlayerWW> getPlayerVote(IPlayerWW playerWW);

    void setPlayerVote(IPlayerWW voterWW, IPlayerWW playerWW);

    void triggerResult();

    Set<? extends IPlayerWW> getAlreadyVotedPlayers();

    Set<? extends IPlayerWW> getVotedPlayers();

    Set<? extends IPlayerWW> getVoters();

    /**
     * Check Vote Status
     */
    boolean isStatus(VoteStatus status);

    /**
     * Set Vote Status
     */
    void setStatus(VoteStatus status);

}
