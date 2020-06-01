package io.github.ph1lou.pluginlgapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

public class BeginSniffEvent extends Event {

    private final UUID playerUUID;
    private final UUID sniffPlayerUUID;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public BeginSniffEvent(UUID playerUUID, UUID sniffPlayerUUID) {
        this.playerUUID =playerUUID;
        this.sniffPlayerUUID = sniffPlayerUUID;
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

    public UUID getSniffPlayerUUID() {
        return sniffPlayerUUID;
    }
}