package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.PlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public class SisterDeathEvent extends Event implements Cancellable {

    private final PlayerWW sister;
    private final Set<PlayerWW> allSisters;
    private final PlayerWW killer;
    private boolean cancel=false;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public SisterDeathEvent(PlayerWW sister, Set<PlayerWW> allSisters,PlayerWW killer){
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

    public PlayerWW getSister() {
        return sister;
    }

    public Set<PlayerWW> getAllSisters() {
        return allSisters;
    }

    @Nullable
    public PlayerWW getKiller() {
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

