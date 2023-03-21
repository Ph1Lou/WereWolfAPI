package fr.ph1lou.werewolfapi.events.game.game_cycle;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsExtraInfo;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsTargets;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

@StatisticsEvent(key = "werewolf.win")
public class WinEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final String role;
    private final Set<IPlayerWW> players;


    public WinEvent(String role, Set<IPlayerWW> players) {
        this.role = role;
        this.players = players;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    @StatisticsExtraInfo
    public String getRole() {
        return role;
    }

    @StatisticsTargets
    public Set<IPlayerWW> getPlayers() {
        return players;
    }
}
