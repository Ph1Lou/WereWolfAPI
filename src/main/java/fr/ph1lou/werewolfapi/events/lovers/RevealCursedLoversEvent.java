package fr.ph1lou.werewolfapi.events.lovers;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsTargets;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

@StatisticsEvent(key = "werewolf.cursed_lover_revelation")
public class RevealCursedLoversEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final Set<IPlayerWW> playerWWS;

    public RevealCursedLoversEvent(Set<IPlayerWW> playerWWS) {
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

    @StatisticsTargets
    public Set<IPlayerWW> getPlayerWWS() {
        return playerWWS;
    }
}

