package fr.ph1lou.werewolfapi.events.werewolf;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class RequestSeeWereWolfListEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final UUID playerUUID;
    private boolean accept = false;

    public RequestSeeWereWolfListEvent(UUID playerUUID) {
        this.playerUUID = playerUUID;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public UUID getPlayerUUID() {
        return playerUUID;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }
}