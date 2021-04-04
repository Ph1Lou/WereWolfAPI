package io.github.ph1lou.werewolfapi.events.random_events;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class TroupleEvent extends Event implements Cancellable {

    private final Set<IPlayerWW> playersUUID;

    private final IPlayerWW playerWW;
    private boolean cancel=false;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public TroupleEvent(IPlayerWW playerWW, Set<IPlayerWW> playerWWS){
        this.playerWW = playerWW;
        this.playersUUID = playerWWS;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public Set<IPlayerWW> getPlayerWWs() {
        return playersUUID;
    }

    public IPlayerWW getPlayerWW() {
        return playerWW;
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

