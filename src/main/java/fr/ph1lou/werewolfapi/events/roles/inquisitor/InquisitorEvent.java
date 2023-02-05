package fr.ph1lou.werewolfapi.events.roles.inquisitor;

import fr.ph1lou.werewolfapi.annotations.TellableStoryEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.inquisitor_event")
@TellableStoryEvent
public class InquisitorEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public InquisitorEvent(IPlayerWW sourceWW, IPlayerWW targetWW) {
        super(sourceWW, targetWW);
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
