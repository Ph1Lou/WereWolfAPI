package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.UUID;

public class GrowlEvent extends Event implements Cancellable {

    private final UUID playerUUID;
    private final List<UUID> playersUUID;
    private boolean cancel=false;

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public GrowlEvent(UUID playerUUID, List<UUID> playersUUID){
        this.playerUUID =playerUUID;
        this.playersUUID =playersUUID;
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

    public List<UUID> getPlayersUUID() {
        return playersUUID;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel=cancel;
    }
}

