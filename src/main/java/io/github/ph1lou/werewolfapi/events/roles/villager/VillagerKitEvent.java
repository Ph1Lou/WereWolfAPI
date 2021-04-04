package io.github.ph1lou.werewolfapi.events.roles.villager;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class VillagerKitEvent extends Event {

    private final IPlayerWW playerWW;
    private final String kit;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public VillagerKitEvent(IPlayerWW playerWW, String kit){
        this.playerWW = playerWW;
        this.kit =kit;
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

    public String getKit() {
        return kit;
    }
}

