package fr.ph1lou.werewolfapi.events.roles.mire;

import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MireEatGappleEvent extends SelectionEvent {


    private static final HandlerList HANDLERS_LIST = new HandlerList();


    public MireEatGappleEvent(IPlayerWW playerWW, IPlayerWW selectionWW){
        super(playerWW, selectionWW);
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

