package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class ModelEvent extends Event {

    private final UUID wildChildUUID;
    private final UUID modelUUID;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public ModelEvent(UUID voterUUID, UUID voteUUID){
        this.wildChildUUID =voterUUID;
        this.modelUUID =voteUUID;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public UUID getWildChildUUID() {
        return wildChildUUID;
    }

    public UUID getModelUUID() {
        return modelUUID;
    }
}

