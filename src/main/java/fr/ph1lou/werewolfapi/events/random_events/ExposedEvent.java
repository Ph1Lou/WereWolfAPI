package fr.ph1lou.werewolfapi.events.random_events;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsPlayer;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsTargets;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@StatisticsEvent(key = "werewolf.exposed")
public class ExposedEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final IPlayerWW playerWW;
    private final List<IPlayerWW> roles;
    private boolean cancel = false;

    public ExposedEvent(IPlayerWW playerWW, List<IPlayerWW> playerWWS) {
        this.playerWW = playerWW;
        this.roles = playerWWS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancel = cancelled;
    }

    @StatisticsPlayer
    public IPlayerWW getPlayerWW() {
        return playerWW;
    }

    public List<IPlayerWW> getRoles() {
        return roles;
    }

    @StatisticsTargets
    public Set<IPlayerWW> getTargets() {
        return new HashSet<>(roles);
    }
}

