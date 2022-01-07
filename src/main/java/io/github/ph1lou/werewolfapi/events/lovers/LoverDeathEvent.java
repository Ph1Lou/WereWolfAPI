
package io.github.ph1lou.werewolfapi.events.lovers;

import io.github.ph1lou.werewolfapi.ILover;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class LoverDeathEvent extends Event {


    private final ILover lover;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public LoverDeathEvent(ILover lover){
        this.lover=lover;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public ILover getLover() {
        return this.lover;
    }

}
