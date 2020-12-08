package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.PlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class AroundLover extends Event {

    private final Set<PlayerWW> playerWWS;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public AroundLover(Set<PlayerWW> playerWWS){
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


    public Set<? extends PlayerWW> getPlayerWWS() {
        return playerWWS;
    }

    public void addPlayer(PlayerWW playerWW){
        this.playerWWS.add(playerWW);
    }


}

