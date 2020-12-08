package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.PlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class UseMaskEvent extends Event implements Cancellable {

    private final PlayerWW playerWW;
    private final int mask;
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean cancel=false;

    public UseMaskEvent(PlayerWW playerWW, int mask){
        this.playerWW =playerWW;
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

    public PlayerWW getPlayerWW() {
        return playerWW;
    }

    public int getMask() {
        return mask;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel=cancel;
    }
}

