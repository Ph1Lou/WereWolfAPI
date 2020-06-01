package io.github.ph1lou.pluginlgapi.events;

import org.bukkit.event.HandlerList;

import java.util.UUID;

public class AmnesiacTransformationEvent extends TransformationEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private final UUID villager;

    public AmnesiacTransformationEvent(UUID uuid, UUID villager){
        super(uuid);
        this.villager = villager;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public UUID getVillager() {
        return villager;
    }
}