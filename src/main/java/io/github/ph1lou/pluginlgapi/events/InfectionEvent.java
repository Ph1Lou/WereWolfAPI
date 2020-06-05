package io.github.ph1lou.pluginlgapi.events;

import org.bukkit.event.HandlerList;

import java.util.UUID;

public class InfectionEvent extends ResurrectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final UUID infectionUUID;

    public InfectionEvent(UUID playerUUID, UUID infectionUUID) {
        super(playerUUID);
        this.infectionUUID = infectionUUID;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public UUID getInfectionUUID() {
        return infectionUUID;
    }
}