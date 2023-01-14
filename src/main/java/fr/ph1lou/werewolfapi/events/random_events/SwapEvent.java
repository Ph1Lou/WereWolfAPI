package fr.ph1lou.werewolfapi.events.random_events;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsPlayer;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsTarget;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.swap_event")
public class SwapEvent extends Event implements Cancellable {


    private final IPlayerWW playerWW1;
    private final IPlayerWW playerWW2;
    private boolean cancel=false;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public SwapEvent(IPlayerWW playerWW1, IPlayerWW playerWW2){
        this.playerWW1 = playerWW1;
        this.playerWW2 = playerWW2;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel=cancel;
    }

    @StatisticsPlayer
    public IPlayerWW getPlayerWW1() {
        return playerWW1;
    }

    @StatisticsTarget
    public IPlayerWW getPlayerWW2() {
        return playerWW2;
    }
}

