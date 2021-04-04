package io.github.ph1lou.werewolfapi.events.lovers;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class CupidLoversEvent extends Event {

    private final IPlayerWW playerWW;
    private final Set<IPlayerWW> playerWWS;

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public CupidLoversEvent(IPlayerWW playerWW, Set<IPlayerWW> playerWWS){
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
        return playerWW;
    }

    public Set<IPlayerWW> getPlayerWWS() {
        return playerWWS;
    }
}

