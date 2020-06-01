package io.github.ph1lou.pluginlgapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.List;
import java.util.UUID;

public class WinEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final String role;
    private final List<UUID> players;


    public WinEvent(String role, List<UUID> players) {
        this.role = role;
        this.players = players;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public String getRole() {
        return role;
    }

    public List<UUID> getPlayers() {
        return players;
    }
}
