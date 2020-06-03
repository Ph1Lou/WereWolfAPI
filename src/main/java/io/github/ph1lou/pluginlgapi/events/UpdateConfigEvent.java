package io.github.ph1lou.pluginlgapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

public class UpdateConfigEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final UUID player;

    public UpdateConfigEvent(UUID player) {
        this.player= player;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public UUID getPlayers() {
        return player;
    }
}
