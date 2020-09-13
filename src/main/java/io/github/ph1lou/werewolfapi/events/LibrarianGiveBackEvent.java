package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class LibrarianGiveBackEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private String info;

    public LibrarianGiveBackEvent(UUID playerUUID, UUID deliveryPlayerUUID, String info) {
        super(playerUUID,deliveryPlayerUUID);
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