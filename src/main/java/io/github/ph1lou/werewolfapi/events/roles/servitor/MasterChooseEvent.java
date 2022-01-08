package io.github.ph1lou.werewolfapi.events.roles.servitor;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import io.github.ph1lou.werewolfapi.events.roles.SelectionEvent;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * @author Héphaïsto
 * Event called when the servitor master is selected
 */
public class MasterChooseEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public MasterChooseEvent(IPlayerWW servitor, IPlayerWW master) {
        super(servitor, master);
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
