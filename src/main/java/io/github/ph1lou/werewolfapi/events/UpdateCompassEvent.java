package io.github.ph1lou.werewolfapi.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class UpdateCompassEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final Collection<? extends Player> players;

    public UpdateCompassEvent(Collection<? extends Player> players) {
        this.players = players;
    }

    public UpdateCompassEvent(Player player) {
        this.players = new ArrayList<>(Collections.singleton(player));
    }


    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public Collection<? extends Player> getPlayers() {
        return players;
    }

}