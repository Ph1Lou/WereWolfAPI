package io.github.ph1lou.pluginlgapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class SisterDeathEvent extends Event {

    private final UUID sister;
    private final List<UUID> allSisters;
    private final UUID killer;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public SisterDeathEvent(UUID sister, List<UUID> allSisters, UUID killer){
        this.sister =sister;
        this.allSisters = allSisters;
        this.killer = killer;
    }

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
    @Nullable
    public UUID getKiller() {
        return killer;
    }
}

