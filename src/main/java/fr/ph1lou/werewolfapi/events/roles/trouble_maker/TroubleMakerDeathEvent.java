package fr.ph1lou.werewolfapi.events.roles.trouble_maker;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class TroubleMakerDeathEvent extends Event {

    private final IPlayerWW playerWW;

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public TroubleMakerDeathEvent(IPlayerWW playerWW){
        this.playerWW = playerWW;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public IPlayerWW getPlayerWW() {
        return this.playerWW;
    }

}

