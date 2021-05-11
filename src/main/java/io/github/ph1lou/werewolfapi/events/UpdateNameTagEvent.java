package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

public class UpdateNameTagEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final UUID uuid;

    public UpdateNameTagEvent(IPlayerWW playerWW){
        this.uuid= playerWW.getUUID();
    }


    public UpdateNameTagEvent(Player player){
        this.uuid = player.getUniqueId();
    }
    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public UUID getUUID(){
        return this.uuid;
    }

}