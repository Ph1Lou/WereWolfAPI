package io.github.ph1lou.werewolfapi.events.roles;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class DisableAbilityEvent extends Event implements Cancellable {

    private final IPlayerWW targetWW;
    private final boolean disable;
    private boolean cancelled = false;

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    /**
     *
     * @param targetWW  Affected player
     * @param disable   True if target's ability is to be disabled, false if it is to be enabled
     */
    public DisableAbilityEvent(IPlayerWW targetWW, boolean disable) {
        this.targetWW = targetWW;
        this.disable = disable;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        cancelled = b;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public IPlayerWW getTargetPlayer() {
        return targetWW;
    }

    /**
     *
     * @return True if target's ability is to be disabled, false if it is to be enabled
     */
    public boolean isDisableMode() {
        return disable;
    }
}
