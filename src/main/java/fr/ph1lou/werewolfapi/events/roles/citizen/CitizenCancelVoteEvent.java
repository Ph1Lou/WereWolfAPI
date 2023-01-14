package fr.ph1lou.werewolfapi.events.roles.citizen;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsPlayer;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsTarget;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.cancel_vote")
public class CitizenCancelVoteEvent extends Event implements Cancellable {

    private final IPlayerWW playerWW;
    private final IPlayerWW voteWW;
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean cancel=false;

    public CitizenCancelVoteEvent(IPlayerWW voterWW, IPlayerWW voteWW){
        this.playerWW =voterWW;
        this.voteWW =voteWW;
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
    public IPlayerWW getPlayerWW() {
        return playerWW;
    }

    @StatisticsTarget
    public IPlayerWW getVoteWW() {
        return voteWW;
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

