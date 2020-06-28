package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.HandlerList;

import java.util.UUID;

public class SuccubusResurrectionEvent extends ResurrectionEvent {

    private final UUID charmedUUID;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public SuccubusResurrectionEvent(UUID playerUUID, UUID charmedUUID) {
        super(playerUUID);
        this.charmedUUID = charmedUUID;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public UUID getCharmedUUID() {
        return charmedUUID;
    }
}