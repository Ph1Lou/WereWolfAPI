package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.HandlerList;

import java.util.UUID;

public class NewWereWolfEvent extends TransformationEvent {

    private boolean cancel=false;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public NewWereWolfEvent(UUID uuid){
        super(uuid);
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancel=b;
    }
}