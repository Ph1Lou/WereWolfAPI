package fr.ph1lou.werewolfapi.vote;

import fr.ph1lou.werewolfapi.enums.VoteStatus;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;

import java.util.Map;
import java.util.Optional;

public interface IVoteManager {

    void setOneVote(IPlayerWW voterWW, IPlayerWW voteWW);
    void resetVote();
    Map<IPlayerWW,Integer> getVotes();
    Map<IPlayerWW, IPlayerWW> getPlayerVotes();
    Optional<IPlayerWW> getResult();
    void showResultVote(IPlayerWW playerWW);
    boolean isStatus(VoteStatus status);
    void setStatus (VoteStatus status);

}
