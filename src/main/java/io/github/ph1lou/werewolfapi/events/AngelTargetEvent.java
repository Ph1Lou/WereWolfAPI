package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class AngelTargetEvent extends Event {

    private final UUID playerUUID;
    private final UUID targetUUID;

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public AngelTargetEvent(UUID playerUUID, UUID targetUUID){
        this.playerUUID =playerUUID;
        this.targetUUID =targetUUID;
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

    public UUID getTargetUUID() {
        return targetUUID;
    }
}

