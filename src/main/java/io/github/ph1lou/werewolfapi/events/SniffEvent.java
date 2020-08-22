package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class SniffEvent extends Event {

    private final UUID playerUUID;
    private final UUID sniffPlayerUUID;
    private final boolean isWereWolf;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public SniffEvent(UUID playerUUID, UUID sniffPlayerUUID, boolean isWereWolf) {
        this.playerUUID =playerUUID;
        this.sniffPlayerUUID = sniffPlayerUUID;
        this.isWereWolf = isWereWolf;
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

    public UUID getSniffPlayerUUID() {
        return sniffPlayerUUID;
    }

    public boolean isWereWolf() {
        return isWereWolf;
    }
}