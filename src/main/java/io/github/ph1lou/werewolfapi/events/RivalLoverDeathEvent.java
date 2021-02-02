package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.PlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RivalLoverDeathEvent extends Event {

    private final PlayerWW playerWW;
    private final List<PlayerWW> playerWWs;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public RivalLoverDeathEvent(PlayerWW playerWW, List<PlayerWW> playerWWs) {
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

    public PlayerWW getPlayerWW() {
        return playerWW;
    }

    public List<PlayerWW> getPlayerWWs() {
        return playerWWs;
    }

}

