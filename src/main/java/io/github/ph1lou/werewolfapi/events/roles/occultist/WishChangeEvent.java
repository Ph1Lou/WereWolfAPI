package io.github.ph1lou.werewolfapi.events.roles.occultist;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import io.github.ph1lou.werewolfapi.events.roles.SelectionEvent;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.checkerframework.common.returnsreceiver.qual.This;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.UUID;

public class WishChangeEvent extends Event implements Cancellable {

    private IPlayerWW playerWW;
    private String wish;
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean cancelled;


    public WishChangeEvent(IPlayerWW playerWW, String wish) {
        super();
        this.playerWW = playerWW;
        this.wish = wish;
    }

    public IPlayerWW getPlayerWW() {
        return playerWW;
    }

    public String getWish() {
        return wish;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancelled = b;
    }
}
