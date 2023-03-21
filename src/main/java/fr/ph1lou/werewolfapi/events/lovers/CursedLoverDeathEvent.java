package fr.ph1lou.werewolfapi.events.lovers;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsPlayer;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsTarget;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;


@StatisticsEvent(key = "werewolf.cursed_lover_death")
public class CursedLoverDeathEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final IPlayerWW playerWW1;
    private final IPlayerWW playerWW2;

    public CursedLoverDeathEvent(IPlayerWW playerWW1, IPlayerWW playerWW2) {
        this.playerWW1 = playerWW1;
        this.playerWW2 = playerWW2;
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
    public IPlayerWW getPlayerWW1() {
        return playerWW1;
    }

    @StatisticsTarget
    public IPlayerWW getPlayerWW2() {
        return playerWW2;
    }

}
