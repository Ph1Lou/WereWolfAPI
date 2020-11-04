package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class NewWereWolfEvent extends Event {


    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private final UUID uuid;

    public NewWereWolfEvent(UUID uuid){
        this.uuid=uuid;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public UUID getUuid() {
        return uuid;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

}