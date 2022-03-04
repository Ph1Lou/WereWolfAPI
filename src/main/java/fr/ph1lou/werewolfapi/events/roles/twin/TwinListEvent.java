package fr.ph1lou.werewolfapi.events.roles.twin;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class TwinListEvent extends Event implements Cancellable {

    private final IPlayerWW playerWW;
    private final Set<IPlayerWW> playerWWS;
    private boolean cancel=false;


    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public TwinListEvent(IPlayerWW playerWW, Set<IPlayerWW> playerWWS){
        this.playerWW = playerWW;
        this.playerWWS = playerWWS;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public IPlayerWW getPlayerWW() {
        return this.playerWW;
    }

    public Set<IPlayerWW> getPlayerWWS() {
        return this.playerWWS;
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

