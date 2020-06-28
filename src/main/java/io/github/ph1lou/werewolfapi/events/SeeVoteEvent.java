package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.Map;
import java.util.UUID;

public class SeeVoteEvent extends Event {

    private final UUID playerUUID;
    private final Map<UUID,Integer> votes;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public SeeVoteEvent(UUID voterUUID, Map<UUID,Integer> votes){
        this.playerUUID =voterUUID;
        this.votes =votes;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public UUID getPlayerUUID() {
        return playerUUID;
    }

    public Map<UUID,Integer> getVotes() {
        return votes;
    }
}

