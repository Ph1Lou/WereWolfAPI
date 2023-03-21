package fr.ph1lou.werewolfapi.events.random_events;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class DiscordEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final Set<IPlayerWW> playerWWs;
    private boolean cancel = false;

    public DiscordEvent(Set<IPlayerWW> playerWWs) {
        this.playerWWs = playerWWs;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    public Set<IPlayerWW> getPlayerWWs() {
        return playerWWs;
    }
}

