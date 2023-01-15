package fr.ph1lou.werewolfapi.events.roles.benefactor;

import fr.ph1lou.werewolfapi.annotations.TellableStoryEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@TellableStoryEvent
@StatisticsEvent(key = "werewolf.benefactor_give_heart_event")
public class BenefactorGiveHeartEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public BenefactorGiveHeartEvent(IPlayerWW playerWW, IPlayerWW target) {
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