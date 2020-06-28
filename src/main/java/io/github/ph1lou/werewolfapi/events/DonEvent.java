package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

public class DonEvent extends Event {

    private final UUID donnerUUID;
    private final UUID receiptUUID;
    private final int don;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public DonEvent(UUID donnerUUID, UUID receiptUUID, int don){
        this.donnerUUID =donnerUUID;
        this.receiptUUID =receiptUUID;
        this.don = don;
    }

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
}

