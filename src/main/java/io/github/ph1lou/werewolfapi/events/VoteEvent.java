package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.PlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class VoteEvent extends SelectionEvent {


    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public VoteEvent(PlayerWW voterWW, PlayerWW voteWW){
        super(voterWW,voteWW);
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

}

