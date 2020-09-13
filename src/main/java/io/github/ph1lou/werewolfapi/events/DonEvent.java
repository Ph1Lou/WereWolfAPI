package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class DonEvent extends Event implements Cancellable {

    private final UUID donnerUUID;
    private final UUID receiptUUID;
    private final int don;
    private boolean cancel=false;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public DonEvent(UUID donnerUUID, UUID receiptUUID, int don){
        this.donnerUUID =donnerUUID;
        this.receiptUUID =receiptUUID;
        this.don = don;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public UUID getDonnerUUID() {
        return donnerUUID;
    }

    public UUID getReceiptUUID() {
        return receiptUUID;
    }

    public int getDon() {
        return don;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel=cancel;
    }
}

