package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.UUID;

public class AroundLover extends Event {

    private final Set<UUID> uuidS;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public AroundLover(Set<UUID> uuidS){
       this.uuidS=uuidS;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }


    public Set<? extends UUID> getUuidS() {
        return uuidS;
    }

    public void addPlayer(UUID uuid){
        this.uuidS.add(uuid);
    }


}

