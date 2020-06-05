package io.github.ph1lou.pluginlgapi.events;

import org.bukkit.event.HandlerList;

import java.util.UUID;

public class TrackEvent extends SelectionEvent {


    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public TrackEvent(UUID playerUUID, UUID targetUUID){
        super(playerUUID,targetUUID);
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }


}

