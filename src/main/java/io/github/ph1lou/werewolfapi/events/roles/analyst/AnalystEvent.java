package io.github.ph1lou.werewolfapi.events.roles.analyst;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import io.github.ph1lou.werewolfapi.events.roles.SelectionEvent;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class AnalystEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private boolean hasEffect;

    public AnalystEvent(IPlayerWW playerWW, IPlayerWW targetUUID, boolean hasEffect){
        super(playerWW,targetUUID);
        this.hasEffect=hasEffect;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public boolean hasEffect() {
        return hasEffect;
    }

    public void setHasEffect(boolean hasEffect) {
        this.hasEffect = hasEffect;
    }

}

