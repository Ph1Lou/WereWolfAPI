package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.PlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class LibrarianRequestEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public LibrarianRequestEvent(PlayerWW playerWW, PlayerWW targetWW) {
        super(playerWW,targetWW);
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