package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class WildChildTransformationEvent extends NewWereWolfEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private final UUID master;

    public WildChildTransformationEvent(UUID uuid, UUID master){
        super(uuid);
        this.master = master;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public UUID getMaster() {
        return master;
    }
}