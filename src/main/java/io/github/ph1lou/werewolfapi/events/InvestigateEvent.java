package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.UUID;

public class InvestigateEvent extends Event implements Cancellable {

    private final List<UUID> playersUUID;

    private final UUID playerUUID;
    private boolean sameCamp;
    private boolean cancel=false;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public InvestigateEvent(UUID playerUUID, List<UUID> playersUUID, boolean sameCamp){
        this.playerUUID=playerUUID;
        this.playersUUID =playersUUID;
        this.sameCamp = sameCamp;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public boolean isSameCamp() {
        return sameCamp;
    }

    public List<UUID> getPlayersUUID() {
        return playersUUID;
    }

    public void setSameCamp(boolean sameCamp) {
        this.sameCamp = sameCamp;
    }

    public UUID getPlayerUUID() {
        return playerUUID;
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

