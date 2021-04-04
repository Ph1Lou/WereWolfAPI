package io.github.ph1lou.werewolfapi;

import io.github.ph1lou.werewolfapi.enums.VoteStatus;

import java.util.Map;

public interface IVoteManager {

    void setUnVote(IPlayerWW voterWW, IPlayerWW voteWW);
    void resetVote();
    void seeVote(IPlayerWW playerWW);
    Map<IPlayerWW,Integer> getVotes();
    Map<IPlayerWW, IPlayerWW> getPlayerVotes();
    IPlayerWW getResult();
    void showResultVote(IPlayerWW playerVoteWW);
    boolean isStatus(VoteStatus status);
    void setStatus (VoteStatus status);

}
