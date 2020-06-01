package io.github.ph1lou.pluginlgapi.events;

import org.bukkit.event.HandlerList;

import java.util.UUID;

public class WitchResurrectionEvent extends ResurrectionEvent {


    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public WitchResurrectionEvent(UUID playerUUID) {
        super(playerUUID);
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

}