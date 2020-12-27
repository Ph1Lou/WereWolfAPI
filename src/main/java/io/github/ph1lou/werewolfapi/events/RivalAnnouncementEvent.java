package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.PlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RivalAnnouncementEvent extends Event implements Cancellable {

    private final List<PlayerWW> playerWWs;

    private final PlayerWW playerWW;
    private boolean cancel=false;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public RivalAnnouncementEvent(PlayerWW playerWW,List<PlayerWW> playerWWs){
        this.playerWW=playerWW;
        this.playerWWs=playerWWs;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public List<PlayerWW> getPlayerWWs() {
        return playerWWs;
    }

    public PlayerWW getPlayerWW() {
        return playerWW;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel=cancel;
    }
}

