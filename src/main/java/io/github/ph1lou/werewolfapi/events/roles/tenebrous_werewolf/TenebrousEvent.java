package io.github.ph1lou.werewolfapi.events.roles.tenebrous_werewolf;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TenebrousEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private boolean cancelled = false;
    private List<IPlayerWW> affectedPlayers;

    public TenebrousEvent(List<IPlayerWW> affectedPlayers) {
        this.affectedPlayers = affectedPlayers;
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
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        cancelled = b;
    }

    public List<IPlayerWW> getAffectedPlayers() {
        return affectedPlayers;
    }

    public void removeAffectedPlayer(IPlayerWW playerWW) {
        affectedPlayers.remove(playerWW);
    }
}
