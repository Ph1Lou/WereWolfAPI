package io.github.ph1lou.pluginlgapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

public class BeginCharmEvent extends Event {

    private final UUID playerUUID;
    private final UUID charmedPlayerUUID;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public BeginCharmEvent(UUID playerUUID, UUID charmedPlayerUUID){
        this.playerUUID =playerUUID;
        this.charmedPlayerUUID =charmedPlayerUUID;
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

    public UUID getCharmedPlayerUUID() {
        return charmedPlayerUUID;
    }
}

