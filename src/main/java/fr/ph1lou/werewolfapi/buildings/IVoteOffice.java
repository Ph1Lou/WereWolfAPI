package fr.ph1lou.werewolfapi.buildings;

import org.bukkit.Location;

import java.util.Map;
import java.util.UUID;

public interface IVoteOffice extends IBuilding {

    Location getUrnLocation();

    int getBaseCapacity();

    int getCapacity();

    int getVotesCast();

    int getRemaining();

    boolean isFull();

    void reduceCapacity(int amount);

    Map<UUID, Integer> getVotesAgainst();

    int getBlankVotes();

    void resetSession();
}
