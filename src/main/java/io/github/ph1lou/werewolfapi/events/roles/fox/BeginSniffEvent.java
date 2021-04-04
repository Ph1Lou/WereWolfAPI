package io.github.ph1lou.werewolfapi.events.roles.fox;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import io.github.ph1lou.werewolfapi.events.roles.SelectionEvent;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

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