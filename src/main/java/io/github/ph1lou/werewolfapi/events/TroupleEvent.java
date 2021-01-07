package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.PlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class TroupleEvent extends Event implements Cancellable {

    private final Set<PlayerWW> playersUUID;

    private final PlayerWW playerWW;
    private boolean cancel=false;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public TroupleEvent(PlayerWW playerWW, Set<PlayerWW> playerWWS){
        this.playerWW=playerWW;
        this.playersUUID =playerWWS;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public Set<PlayerWW> getPlayerWWs() {
        return playersUUID;
    }

    public PlayerWW getPlayerWW() {
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

