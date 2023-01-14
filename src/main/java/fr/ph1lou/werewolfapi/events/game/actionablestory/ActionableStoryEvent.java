package fr.ph1lou.werewolfapi.events.game.actionablestory;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;


public class ActionableStoryEvent extends Event implements Cancellable {

    private final UUID player;
    private boolean cancel = false;
    private final String event;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public ActionableStoryEvent(UUID player, String event) {
        this.player = player;
        this.event = event;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public UUID getPlayer() {
        return player;
    }

    @Override
    public boolean isCancelled() {
        return this.cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    public String getEvent() {
        return event;
    }
}