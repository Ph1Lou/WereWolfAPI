package fr.ph1lou.werewolfapi.buildings;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.Location;

import java.util.Map;

public interface IVoteOffice extends IBuilding {

    Location getUrnLocation();

    Location getChestLocation();

    int getBaseCapacity();

    int getCapacity();

    int getVotesCast();

    int getRemaining();

    boolean isFull();

    void reduceCapacity(int amount);

    boolean hasBlankVoted(IPlayerWW player);

    void recordVoteAgainst(IPlayerWW target);

    void recordBlank(IPlayerWW player);

    Map<IPlayerWW, Integer> getVotesAgainst();

    int getBlankVotes();

    void resetSession();
}
