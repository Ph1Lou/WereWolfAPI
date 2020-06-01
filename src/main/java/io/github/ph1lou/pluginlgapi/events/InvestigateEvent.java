package io.github.ph1lou.pluginlgapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.List;
import java.util.UUID;

public class InvestigateEvent extends Event {

    private final UUID playerUUID;
    private final List<UUID> playersUUID;
    private final boolean sameCamp;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public InvestigateEvent(UUID playerUUID, List<UUID> playersUUID, boolean sameCamp){
        this.playerUUID =playerUUID;
        this.playersUUID =playersUUID;
        this.sameCamp = sameCamp;
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

    public boolean isSameCamp() {
        return sameCamp;
    }

    public List<UUID> getPlayersUUID() {
        return playersUUID;
    }
}

