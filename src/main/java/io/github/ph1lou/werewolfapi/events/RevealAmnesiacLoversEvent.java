package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.PlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class RevealAmnesiacLoversEvent extends Event {


    private final Set<PlayerWW> playerWWS;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public RevealAmnesiacLoversEvent(Set<PlayerWW> playerWWS) {
        this.playerWWS = playerWWS;
    }


    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public Set<PlayerWW> getPlayerWWS() {
        return playerWWS;
    }
}

