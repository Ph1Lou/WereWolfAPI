package io.github.ph1lou.werewolfapi.events.roles.village_idiot;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import io.github.ph1lou.werewolfapi.events.roles.SelectionEvent;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class VillageIdiotEvent extends SelectionEvent {


    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public VillageIdiotEvent(IPlayerWW playerWW, IPlayerWW targetWW) {
        super(playerWW,targetWW);
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