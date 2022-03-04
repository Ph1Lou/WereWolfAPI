package fr.ph1lou.werewolfapi.events.roles.detective;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class InvestigateEvent extends Event implements Cancellable {

    private final Set<IPlayerWW> playersUUID;

    private final IPlayerWW playerWW;
    private boolean sameCamp;
    private boolean cancel=false;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public InvestigateEvent(IPlayerWW playerWW, Set<IPlayerWW> playerWWS, boolean sameCamp){
        this.playerWW = playerWW;
        this.playersUUID = playerWWS;
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

    public Set<IPlayerWW> getPlayerWWs() {
        return playersUUID;
    }

    public void setSameCamp(boolean sameCamp) {
        this.sameCamp = sameCamp;
    }

    public IPlayerWW getPlayerWW() {
        return this.playerWW;
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

