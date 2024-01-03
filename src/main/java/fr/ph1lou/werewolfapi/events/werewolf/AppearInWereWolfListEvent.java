package fr.ph1lou.werewolfapi.events.werewolf;

import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class AppearInWereWolfListEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean appear = false;

    public AppearInWereWolfListEvent(IPlayerWW playerWW, IPlayerWW target) {
        super(playerWW, target);
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public boolean isAppear() {
        return appear;
    }

    public void setAppear(boolean appear) {
        this.appear = appear;
    }
}