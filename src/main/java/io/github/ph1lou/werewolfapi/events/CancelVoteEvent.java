package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.PlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class CancelVoteEvent extends Event implements Cancellable {

    private final PlayerWW playerWW;
    private final PlayerWW voteWW;
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean cancel=false;

    public CancelVoteEvent(PlayerWW voterWW, PlayerWW voteWW){
        this.playerWW =voterWW;
        this.voteWW =voteWW;
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

    public PlayerWW getVoteWW() {
        return voteWW;
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

