package fr.ph1lou.werewolfapi.events.roles.mastermind;

import fr.ph1lou.werewolfapi.annotations.TellableStoryEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;


@StatisticsEvent(key = "werewolf.mastermind_event")
@TellableStoryEvent
public class MastermindEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public MastermindEvent(IPlayerWW playerWW, IPlayerWW target) {
        super(playerWW, target);

    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

}

