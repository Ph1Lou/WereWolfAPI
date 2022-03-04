package fr.ph1lou.werewolfapi.events.roles.charmer;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class CharmedDeathEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private final boolean beforeCountDown;

    public CharmedDeathEvent(IPlayerWW playerWW, IPlayerWW charmerWW, boolean beforeCountDown) {
        super(playerWW, charmerWW);
        this.beforeCountDown=beforeCountDown;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public boolean isBeforeCountDown() {
        return this.beforeCountDown;
    }
}