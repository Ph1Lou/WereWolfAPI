package fr.ph1lou.werewolfapi.events.roles.occultist;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsPlayer;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.reveal_wishes_occultist")
public class OccultistRevealWishesEvent extends Event implements Cancellable {

    private boolean cancelled = false;
    private final IPlayerWW playerWW;

    public OccultistRevealWishesEvent(IPlayerWW playerWW) {
        this.playerWW = playerWW;
    }

    private static final HandlerList HANDLERS_LIST = new HandlerList();
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

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancelled = b;
    }
}
