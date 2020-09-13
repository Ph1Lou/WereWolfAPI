package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class VoteResultEvent extends Event implements Cancellable {

    private UUID playerVotedUUID=null;
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean cancel=false;



    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }


    public void setPlayerVotedUUID(UUID uuid){
        this.playerVotedUUID=uuid;
    }

    public UUID getPlayerVoteUUID(){
        return playerVotedUUID;
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
