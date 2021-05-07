package io.github.ph1lou.werewolfapi.events.roles.shaman;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class ShamanEvent extends Event implements Cancellable {

    private boolean cancel;
    private final IPlayerWW victim;
    private final IPlayerWW killer;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public ShamanEvent(IPlayerWW victim, IPlayerWW killer) {
        this.killer = killer;
        this.victim = victim;
        this.cancel = false;
    }

    @Override
    public boolean isCancelled() {
        return this.cancel;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancel = b;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public IPlayerWW getVictim() {
        return this.victim;
    }

    public Optional<IPlayerWW> getKiller() {
        return Optional.ofNullable(this.killer);
    }
}
