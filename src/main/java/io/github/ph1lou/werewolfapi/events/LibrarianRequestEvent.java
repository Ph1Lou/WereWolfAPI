package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class LibrarianRequestEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public LibrarianRequestEvent(UUID playerUUID, UUID deliveryPlayerUUID) {
        super(playerUUID,deliveryPlayerUUID);
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