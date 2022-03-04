package fr.ph1lou.werewolfapi.events.roles.thug;

import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class ThugEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public ThugEvent(IPlayerWW playerWW, IPlayerWW targetUUID){
        super(playerWW,targetUUID);

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

