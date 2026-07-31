package fr.ph1lou.werewolfapi.events.buildings;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsPlayer;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

@StatisticsEvent(key = "werewolf.urn_vote_result")
public class UrnVoteResultEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private IPlayerWW playerWW;
    private int votes;
    private int session;
    private final Map<IPlayerWW, Integer> totals;
    private boolean cancel = false;

    public UrnVoteResultEvent(IPlayerWW playerWW, int votes, int session, Map<IPlayerWW, Integer> totals) {
        this.playerWW = playerWW;
        this.votes = votes;
        this.session = session;
        this.totals = totals;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    @StatisticsPlayer
    public IPlayerWW getPlayerWW() {
        return playerWW;
    }

    public void setPlayerWW(IPlayerWW playerWW) {
        this.playerWW = playerWW;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public int getSession() {
        return session;
    }

    public Map<IPlayerWW, Integer> getTotals() {
        return totals;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }
}
