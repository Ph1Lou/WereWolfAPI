package fr.ph1lou.werewolfapi.game.events.roles.servitor;

import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * @author Héphaïsto
 * Event called when a master kill a servitor for the first time, the master is now definitive
 */
public class DefinitiveMasterEvent extends SelectionEvent {
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public DefinitiveMasterEvent(IPlayerWW servitor, IPlayerWW master) {
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
