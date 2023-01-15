package fr.ph1lou.werewolfapi.events.roles.succubus;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsTarget;
import fr.ph1lou.werewolfapi.events.game.life_cycle.ResurrectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.succubus_resurrection")
public class SuccubusResurrectionEvent extends ResurrectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final IPlayerWW targetWW;

    public SuccubusResurrectionEvent(IPlayerWW playerWW, IPlayerWW targetWW) {
        super(playerWW);
        this.targetWW = targetWW;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    @StatisticsTarget
    public IPlayerWW getTargetWW() {
        return targetWW;
    }
}