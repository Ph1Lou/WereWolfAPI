package fr.ph1lou.werewolfapi.events.roles.spy;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.spy_choose_event")
public class SpyChoseEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public SpyChoseEvent(IPlayerWW playerWW, IPlayerWW targetUUID) {
        super(playerWW, targetUUID);

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

