package io.github.ph1lou.werewolfapi.events.game.day_cycle;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class DayEvent extends Event {

    private final int number;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public DayEvent(int number){
        this.number = number;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public int getNumber() {
        return number;
    }
}
