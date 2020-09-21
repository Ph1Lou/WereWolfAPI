package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.UUID;

public class SisterDeathEvent extends Event implements Cancellable {

    private final UUID sister;
    private final List<UUID> allSisters;
    private final UUID killer;
    private boolean cancel=false;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public SisterDeathEvent(UUID sister, List<UUID> allSisters, UUID killer){
        this.sister =sister;
        this.allSisters = allSisters;
        this.killer = killer;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public UUID getSister() {
        return sister;
    }

    public List<UUID> getAllSisters() {
        return allSisters;
    }


    public UUID getKiller() {
        return killer;
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

