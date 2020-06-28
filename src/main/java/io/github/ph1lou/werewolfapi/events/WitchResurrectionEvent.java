package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.HandlerList;

import java.util.UUID;

public class WitchResurrectionEvent extends ResurrectionEvent {


    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final UUID resurrectionUUID;

    public WitchResurrectionEvent(UUID playerUUID, UUID resurrectionUUID) {
        super(playerUUID);
        this.resurrectionUUID = resurrectionUUID;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public UUID getResurrectionUUID() {
        return resurrectionUUID;
    }
}