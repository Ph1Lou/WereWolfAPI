package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.PlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class SniffEvent extends SelectionEvent {


    private boolean isWereWolf;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public SniffEvent(PlayerWW playerWW, PlayerWW targetWW, boolean isWereWolf) {
        super(playerWW,targetWW);
        this.isWereWolf = isWereWolf;
    }


    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }


    public boolean isWereWolf() {
        return isWereWolf;
    }

    public void setWereWolf(boolean wereWolf) {
        isWereWolf = wereWolf;
    }
}