package fr.ph1lou.werewolfapi.events.roles.sister;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public class SisterDeathEvent extends Event implements Cancellable {

    private final IPlayerWW sister;
    private final Set<IPlayerWW> allSisters;
    private final IPlayerWW killer;
    private boolean cancel=false;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public SisterDeathEvent(IPlayerWW sister, Set<IPlayerWW> allSisters, IPlayerWW killer){
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

    public IPlayerWW getSister() {
        return sister;
    }

    public Set<IPlayerWW> getAllSisters() {
        return allSisters;
    }

    @Nullable
    public IPlayerWW getKiller() {
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

