package io.github.ph1lou.pluginlgapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

public class TroubleMakerDeathEvent extends Event {

    private final UUID playerUUID;

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public TroubleMakerDeathEvent(UUID playerUUID){
        this.playerUUID =playerUUID;
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

}

