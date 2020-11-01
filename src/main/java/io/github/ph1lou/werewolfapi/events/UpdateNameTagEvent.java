package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UpdateNameTagEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final List<UUID> playersUUID=new ArrayList<>();

    public UpdateNameTagEvent(UUID playerUUID){
        this.playersUUID.add(playerUUID);
    }

    public UpdateNameTagEvent(List<UUID> playersUUID){
        this.playersUUID.addAll(playersUUID);
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public List<UUID> getPlayersUUID(){
        return this.playersUUID;
    }

    public void addPlayer(UUID playerUUID){
        this.playersUUID.add(playerUUID);
    }

}