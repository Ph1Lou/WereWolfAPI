package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.PlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class InvestigateEvent extends Event implements Cancellable {

    private final Set<PlayerWW> playersUUID;

    private final PlayerWW playerWW;
    private boolean sameCamp;
    private boolean cancel=false;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public InvestigateEvent(PlayerWW playerWW, Set<PlayerWW> playerWWS, boolean sameCamp){
        this.playerWW=playerWW;
        this.playersUUID =playerWWS;
        this.sameCamp = sameCamp;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public boolean isSameCamp() {
        return sameCamp;
    }

    public Set<PlayerWW> getPlayerWWs() {
        return playersUUID;
    }

    public void setSameCamp(boolean sameCamp) {
        this.sameCamp = sameCamp;
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

