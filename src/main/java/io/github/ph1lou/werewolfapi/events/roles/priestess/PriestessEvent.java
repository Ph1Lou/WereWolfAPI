package io.github.ph1lou.werewolfapi.events.roles.priestess;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import io.github.ph1lou.werewolfapi.events.roles.SelectionEvent;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class PriestessEvent extends SelectionEvent {

    private String camp;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public PriestessEvent(IPlayerWW playerWW, IPlayerWW targetWW, String camp){
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

