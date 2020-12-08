package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.PlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class SeerEvent extends SelectionEvent {

    private String camp;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public SeerEvent(PlayerWW playerWW, PlayerWW targetWW, String camp){
        super(playerWW,targetWW);
        this.camp=camp;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public String getCamp() {
        return camp;
    }

    public void setCamp(String camp) {
        this.camp = camp;
    }

}

