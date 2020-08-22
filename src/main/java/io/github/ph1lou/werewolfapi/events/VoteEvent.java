package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class VoteEvent extends Event {

    private final UUID voterUUID;
    private final UUID voteUUID;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public VoteEvent(UUID voterUUID,UUID voteUUID){
        this.voterUUID =voterUUID;
        this.voteUUID =voteUUID;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public UUID getVoterUUID() {
        return voterUUID;
    }

    public UUID getVoteUUID() {
        return voteUUID;
    }
}

