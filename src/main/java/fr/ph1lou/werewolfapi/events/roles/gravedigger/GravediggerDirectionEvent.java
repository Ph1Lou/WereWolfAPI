package fr.ph1lou.werewolfapi.events.roles.gravedigger;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * @author havwila
 */

public class GravediggerDirectionEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final IPlayerWW sourceWW;
    private final IPlayerWW targetWW;
    private boolean cancelled;
    private double angle;

    public GravediggerDirectionEvent(double angle, IPlayerWW sourceWW, IPlayerWW targetWW) {
        this.angle = angle;
        this.sourceWW = sourceWW;
        this.targetWW = targetWW;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
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

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public IPlayerWW getSourceWW() {
        return sourceWW;
    }

    public IPlayerWW getTargetWW() {
        return targetWW;
    }
}
