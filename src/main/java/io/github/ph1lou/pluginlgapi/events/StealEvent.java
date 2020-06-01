
package io.github.ph1lou.pluginlgapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

public class StealEvent extends Event {

    private final UUID newUUID;
    private final UUID oldUUID;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public StealEvent(UUID newUUID, UUID oldUUID){
        this.newUUID=newUUID;
        this.oldUUID=oldUUID;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public UUID getNewUUID() {
        return newUUID;
    }

    public UUID getOldUUID() {
        return oldUUID;
    }
}
