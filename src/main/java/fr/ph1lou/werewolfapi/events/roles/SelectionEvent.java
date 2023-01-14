package fr.ph1lou.werewolfapi.events.roles;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsPlayer;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsTarget;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class SelectionEvent extends Event implements Cancellable {

    private final IPlayerWW playerWW;
    private final IPlayerWW targetWW;
    private boolean cancel=false;

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public SelectionEvent(IPlayerWW playerWW, IPlayerWW targetWW){
        this.playerWW = playerWW;
        this.targetWW =targetWW;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @StatisticsPlayer
    public final IPlayerWW getPlayerWW() {
        return this.playerWW;
    }

    @StatisticsTarget
    public final IPlayerWW getTargetWW() {
        return targetWW;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancel=b;
    }
}

