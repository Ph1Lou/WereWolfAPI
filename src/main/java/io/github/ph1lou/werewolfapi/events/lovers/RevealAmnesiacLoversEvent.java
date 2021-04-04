package io.github.ph1lou.werewolfapi.events.lovers;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class RevealAmnesiacLoversEvent extends Event {


    private final Set<IPlayerWW> playerWWS;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public RevealAmnesiacLoversEvent(Set<IPlayerWW> playerWWS) {
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

    public Set<IPlayerWW> getPlayerWWS() {
        return playerWWS;
    }
}

