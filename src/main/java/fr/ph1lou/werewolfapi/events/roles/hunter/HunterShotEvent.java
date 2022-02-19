package fr.ph1lou.werewolfapi.events.roles.hunter;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class HunterShotEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private IPlayerWW targetWW;
    private final IPlayerWW sourceWW;
    private boolean cancel = false;

    public HunterShotEvent(IPlayerWW targetWW, IPlayerWW sourceWW) {
        this.targetWW = targetWW;
        this.sourceWW = sourceWW;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean b) {
        cancel = b;
    }

    public IPlayerWW getTarget() {
        return targetWW;
    }

    public IPlayerWW getSource() {
        return sourceWW;
    }

    public void setTarget(IPlayerWW targetWW) {
        this.targetWW = targetWW;
    }
}
