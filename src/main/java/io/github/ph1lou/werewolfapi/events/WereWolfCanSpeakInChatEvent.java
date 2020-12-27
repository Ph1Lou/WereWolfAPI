package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.PlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class WereWolfCanSpeakInChatEvent extends Event {

    private final PlayerWW playerWW;

    private boolean canSpeak=false;

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public WereWolfCanSpeakInChatEvent(PlayerWW playerWW){
        this.playerWW=playerWW;
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

    public boolean canSpeak() {
        return canSpeak;
    }

    public void setCanSpeak(boolean canSpeak){
        this.canSpeak=canSpeak;
    }
}

