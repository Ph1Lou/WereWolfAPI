package fr.ph1lou.werewolfapi.events.buildings;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsPlayer;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsTarget;
import fr.ph1lou.werewolfapi.buildings.IVoteOffice;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StatisticsEvent(key = "werewolf.urn_vote_cast")
public class UrnVoteCastEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private final IPlayerWW voter;
    private final IPlayerWW target;
    private final boolean blank;
    private final int session;
    @Nullable
    private final IVoteOffice office;
    private boolean cancel = false;

    public UrnVoteCastEvent(IPlayerWW voter, @Nullable IPlayerWW target, boolean blank, int session, @Nullable IVoteOffice office) {
        this.voter = voter;
        this.target = target;
        this.blank = blank;
        this.session = session;
        this.office = office;
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
        return voter;
    }

    @StatisticsTarget
    public IPlayerWW getTargetWW() {
        return target;
    }

    public boolean isBlank() {
        return blank;
    }

    public int getSession() {
        return session;
    }

    @Nullable
    public IVoteOffice getOffice() {
        return office;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancel = cancelled;
    }
}
