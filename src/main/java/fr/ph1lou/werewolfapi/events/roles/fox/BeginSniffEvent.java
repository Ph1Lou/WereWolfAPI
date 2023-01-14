package fr.ph1lou.werewolfapi.events.roles.fox;

import fr.ph1lou.werewolfapi.annotations.TellableStoryEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.begin_smell")
@TellableStoryEvent
public class BeginSniffEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public BeginSniffEvent(IPlayerWW playerWW, IPlayerWW sniffIPlayerWW) {
        super(playerWW, sniffIPlayerWW);
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

}