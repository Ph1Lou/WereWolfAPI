package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.PlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class WinEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final String role;
    private final Set<PlayerWW> players;


    public WinEvent(String role, Set<PlayerWW> players) {
        this.role = role;
        this.players = players;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public String getRole() {
        return role;
    }

    public Set<PlayerWW> getPlayers() {
        return players;
    }
}
