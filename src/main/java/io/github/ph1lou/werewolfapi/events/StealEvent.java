
package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class StealEvent extends Event {

    private final UUID killer;
    private final UUID player;
    private final String role;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public StealEvent(UUID killer, UUID player, String role){
        this.killer =killer;
        this.player =player;
        this.role=role;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public UUID getKiller() {
        return killer;
    }

    public UUID getPlayer() {
        return player;
    }

    public String getRole() {
        return role;
    }
}
