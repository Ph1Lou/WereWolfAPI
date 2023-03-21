package fr.ph1lou.werewolfapi.events.werewolf;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class AppearInWereWolfListEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final UUID playerUUID;

    private final UUID requesterUUID;
    private boolean appear = false;

    public AppearInWereWolfListEvent(UUID playerUUID, UUID requester) {
        this.playerUUID = playerUUID;
        this.requesterUUID = requester;
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

    public UUID getRequesterUUID() {
        return requesterUUID;
    }

    public boolean isAppear() {
        return appear;
    }

    public void setAppear(boolean appear) {
        this.appear = appear;
    }
}