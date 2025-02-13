package fr.ph1lou.werewolfapi.events.werewolf;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;


public class WereWolfCanHowlingEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private final IPlayerWW playerWW;

    private boolean canHowling = false;

    public WereWolfCanHowlingEvent(IPlayerWW playerWW) {
        this.playerWW = playerWW;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public IPlayerWW getPlayerWW() {
        return playerWW;
    }

    public boolean isCanHowling() {
        return canHowling;
    }

    public void setCanHowling(boolean canHowling) {
        this.canHowling = canHowling;
    }
}

