package fr.ph1lou.werewolfapi.events.game.timers;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class PVPEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();


    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

}
