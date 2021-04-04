package io.github.ph1lou.werewolfapi.events.lovers;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class AroundLover extends Event {

    private final Set<IPlayerWW> playerWWS;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public AroundLover(Set<IPlayerWW> playerWWS){
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


    public Set<? extends IPlayerWW> getPlayerWWS() {
        return playerWWS;
    }

    public void addPlayer(IPlayerWW playerWW){
        this.playerWWS.add(playerWW);
    }


}

