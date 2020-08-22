package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class UseMaskEvent extends Event {

    private final UUID playerUUID;
    private final int mask;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public UseMaskEvent(UUID playerUUID, int mask){
        this.playerUUID =playerUUID;
        this.mask = mask;
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

    public int getMask() {
        return mask;
    }
}

