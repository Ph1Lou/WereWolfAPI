package fr.ph1lou.werewolfapi.events.roles.servitor;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * @author Héphaïsto
 * Event called when the servitor master is selected
 */

@StatisticsEvent(key = "werewolf.servitor_master_chosen")
public class ServitorMasterChosenEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public ServitorMasterChosenEvent(IPlayerWW servitor, IPlayerWW master) {
        super(servitor, master);
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
