package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.PlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class SelectionEvent extends Event implements Cancellable {

    private final PlayerWW playerWW;
    private final PlayerWW targetWW;
    private boolean cancel=false;

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public SelectionEvent(PlayerWW playerWW, PlayerWW targetWW){
        this.playerWW =playerWW;
        this.targetWW =targetWW;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public final PlayerWW getPlayerWW() {
        return playerWW;
    }

    public final PlayerWW getTargetWW() {
        return targetWW;
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

