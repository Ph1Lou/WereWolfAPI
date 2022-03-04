package fr.ph1lou.werewolfapi.events.roles.amnesiac;

import fr.ph1lou.werewolfapi.events.roles.TransformationEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class AmnesiacTransformationEvent extends TransformationEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private final IPlayerWW villager;

    public AmnesiacTransformationEvent(@NotNull IPlayerWW playerWW, @NotNull IPlayerWW villager){
        super(playerWW);
        this.villager = villager;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public IPlayerWW getVillager() {
        return villager;
    }

}