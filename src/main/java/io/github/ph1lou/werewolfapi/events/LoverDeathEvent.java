
package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class LoverDeathEvent extends Event {

    private final UUID lover1Uuid;
    private final UUID lover2Uuid;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public LoverDeathEvent(UUID lover1Uuid, UUID lover2Uuid){
        this.lover1Uuid =lover1Uuid;
        this.lover2Uuid =lover2Uuid;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public UUID getLover1Uuid() {
        return lover1Uuid;
    }

    public UUID getLover2Uuid() {
        return lover2Uuid;
    }

}
