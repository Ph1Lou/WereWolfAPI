package io.github.ph1lou.pluginlgapi;

import io.github.ph1lou.pluginlgapi.enumlg.VoteStatus;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public interface Vote {

    void setUnVote(UUID voterUUID, UUID vote);
    void resetVote();
    void seeVote(Player player);
    Map<UUID,Integer> getVotes();
    UUID getResult();
    void showResultVote(UUID playerVoteUUID);
    boolean isStatus(VoteStatus status);
    void setStatus (VoteStatus status);

}
