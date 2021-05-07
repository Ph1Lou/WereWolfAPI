package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;

public class UpdateNameTagEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final IPlayerWW playerWW;

    public UpdateNameTagEvent(IPlayerWW playerWW){
        this.playerWW= playerWW;
    }


    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public IPlayerWW getPlayerWW(){
        return this.playerWW;
    }

}