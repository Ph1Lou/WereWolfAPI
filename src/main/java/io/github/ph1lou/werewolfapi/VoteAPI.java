package io.github.ph1lou.werewolfapi;

import io.github.ph1lou.werewolfapi.enumlg.VoteStatus;

import java.util.Map;

public interface VoteAPI {

    void setUnVote(PlayerWW voterWW, PlayerWW voteWW);
    void resetVote();
    void seeVote(PlayerWW playerWW);
    Map<PlayerWW,Integer> getVotes();
    Map<PlayerWW,PlayerWW> getPlayerVotes();
    PlayerWW getResult();
    void showResultVote(PlayerWW playerVoteWW);
    boolean isStatus(VoteStatus status);
    void setStatus (VoteStatus status);

}
