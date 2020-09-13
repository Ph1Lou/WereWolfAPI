package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.UUID;

public class SeeVoteEvent extends Event implements Cancellable {

    private final UUID playerUUID;
    private final Map<UUID,Integer> votes;
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean cancel=false;

    public SeeVoteEvent(UUID voterUUID, Map<UUID,Integer> votes){
        this.playerUUID =voterUUID;
        this.votes =votes;
    }

    @NotNull
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

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel=cancel;
    }
}

