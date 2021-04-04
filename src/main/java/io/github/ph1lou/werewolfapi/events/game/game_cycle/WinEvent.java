package io.github.ph1lou.werewolfapi.events.game.game_cycle;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class WinEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final String role;
    private final Set<IPlayerWW> players;


    public WinEvent(String role, Set<IPlayerWW> players) {
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

    public Set<IPlayerWW> getPlayers() {
        return players;
    }
}
