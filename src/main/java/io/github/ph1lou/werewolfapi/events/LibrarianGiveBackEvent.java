package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.PlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class LibrarianGiveBackEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private String info;

    public LibrarianGiveBackEvent(PlayerWW playerWW, PlayerWW targetWW, String info) {
        super(playerWW,targetWW);
        this.info=info;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}