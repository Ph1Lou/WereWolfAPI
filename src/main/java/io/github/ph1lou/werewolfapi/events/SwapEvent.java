package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.PlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class SwapEvent extends Event implements Cancellable {


    private final PlayerWW playerWW1;
    private final PlayerWW playerWW2;
    private boolean cancel=false;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public SwapEvent(PlayerWW playerWW1, PlayerWW playerWW2){
        this.playerWW1=playerWW1;
        this.playerWW2=playerWW2;
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
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel=cancel;
    }

    public PlayerWW getPlayerWW1() {
        return playerWW1;
    }

    public PlayerWW getPlayerWW2() {
        return playerWW2;
    }
}

