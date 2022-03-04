package fr.ph1lou.werewolfapi.events.roles.serial_killer;

import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class SerialKillerEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public SerialKillerEvent(IPlayerWW playerWW, IPlayerWW targetWW){
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

