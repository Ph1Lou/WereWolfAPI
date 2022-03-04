package fr.ph1lou.werewolfapi.events.roles.wild_child;

import fr.ph1lou.werewolfapi.events.roles.TransformationEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class WildChildTransformationEvent extends TransformationEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private final IPlayerWW model;

    public WildChildTransformationEvent(IPlayerWW playerWW, IPlayerWW model){
        super(playerWW);
        this.model = model;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public IPlayerWW getModel() {
        return model;
    }
}