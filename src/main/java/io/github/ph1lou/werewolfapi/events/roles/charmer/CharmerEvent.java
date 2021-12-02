package io.github.ph1lou.werewolfapi.events.roles.charmer;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import io.github.ph1lou.werewolfapi.events.roles.SelectionEvent;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class CharmerEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public CharmerEvent(IPlayerWW playerWW, IPlayerWW charmerWW) {
        super(playerWW, charmerWW);
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