package fr.ph1lou.werewolfapi.events.roles.rival;

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

@StatisticsEvent(key = "werewolf.rival_announcement")
public class RivalAnnouncementEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final List<IPlayerWW> playerWWS;
    private final IPlayerWW playerWW;
    private boolean cancel = false;

    public RivalAnnouncementEvent(IPlayerWW playerWW, List<IPlayerWW> playerWWS) {
        this.playerWW = playerWW;
        this.playerWWS = playerWWS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public List<IPlayerWW> getPlayerWWs() {
        return playerWWS;
    }

    @StatisticsTargets
    public Set<IPlayerWW> getTargets() {
        return new HashSet<>(playerWWS);
    }

    @StatisticsPlayer
    public IPlayerWW getPlayerWW() {
        return this.playerWW;
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

