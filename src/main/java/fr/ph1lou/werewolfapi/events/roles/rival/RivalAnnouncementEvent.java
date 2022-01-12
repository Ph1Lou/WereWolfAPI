package fr.ph1lou.werewolfapi.events.roles.rival;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RivalAnnouncementEvent extends Event implements Cancellable {

    private final List<IPlayerWW> playerWWS;

    private final IPlayerWW playerWW;
    private boolean cancel=false;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public RivalAnnouncementEvent(IPlayerWW playerWW, List<IPlayerWW> playerWWS){
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

    public List<IPlayerWW> getPlayerWWs() {
        return playerWWS;
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

