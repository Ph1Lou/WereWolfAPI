package io.github.ph1lou.pluginlgapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

public class TrackEvent extends Event {

    private final UUID playerUUID;
    private final UUID targetUUID;

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public TrackEvent(UUID playerUUID, UUID targetUUID){
        this.playerUUID =playerUUID;
        this.targetUUID =targetUUID;
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

    public UUID getTargetUUID() {
        return targetUUID;
    }
}

