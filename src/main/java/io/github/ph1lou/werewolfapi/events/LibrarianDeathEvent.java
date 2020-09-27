package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class LibrarianDeathEvent extends Event {

    private final UUID playerUUID;

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public LibrarianDeathEvent(UUID playerUUID){
        this.playerUUID =playerUUID;
    }

    @NotNull
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

