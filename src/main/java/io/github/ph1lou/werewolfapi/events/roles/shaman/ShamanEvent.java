package io.github.ph1lou.werewolfapi.events.roles.shaman;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class ShamanEvent extends Event {

    private boolean cancel;
    private final IPlayerWW victim;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public ShamanEvent(IPlayerWW victim) {
        this.victim = victim;
        this.cancel = false;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public IPlayerWW getVictim() {
        return victim;
    }
}
