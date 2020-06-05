package io.github.ph1lou.pluginlgapi.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

public class SelectionEvent extends Event implements Cancellable {

    private final UUID playerUUID;
    private final UUID targetUUID;
    private boolean cancel=false;

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public SelectionEvent(UUID playerUUID, UUID targetUUID){
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

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancel=b;
    }
}

