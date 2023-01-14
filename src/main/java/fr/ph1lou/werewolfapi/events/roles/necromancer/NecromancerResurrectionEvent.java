package fr.ph1lou.werewolfapi.events.roles.necromancer;

import fr.ph1lou.werewolfapi.annotations.TellableStoryEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsTarget;
import fr.ph1lou.werewolfapi.events.game.life_cycle.ResurrectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.necromancer_event")
@TellableStoryEvent
public class NecromancerResurrectionEvent extends ResurrectionEvent {

    private final IPlayerWW targetWW;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public NecromancerResurrectionEvent(IPlayerWW playerWW, IPlayerWW targetWW) {
        super(playerWW);
        this.targetWW = targetWW;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @StatisticsTarget
    public IPlayerWW getTargetWW() {
        return targetWW;
    }
}