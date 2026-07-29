package fr.ph1lou.werewolfapi.events.buildings;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class UrnVote1StartEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public UrnVote1StartEvent() {
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }
}
