package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.PlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class VillagerKitEvent extends Event {

    private final PlayerWW playerWW;
    private final String kit;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public VillagerKitEvent(PlayerWW playerWW, String kit){
        this.playerWW=playerWW;
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

    public PlayerWW getPlayerWW() {
        return playerWW;
    }

    public String getKit() {
        return kit;
    }
}

