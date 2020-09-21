package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.UUID;

public class CustomEvent extends Event implements Cancellable {

    private final UUID playerUUID;
    private final List<UUID> targetUUIDs;

    private final int extraInt;
    private final String extraInfo;
    private boolean cancel=false;
    private final String event;

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public CustomEvent(UUID playerUUID, List<UUID> targetUUIDs, int extraInt, String extraInfo, String event){
        this.playerUUID =playerUUID;
        this.targetUUIDs =targetUUIDs;
        this.extraInt = extraInt;
        this.extraInfo = extraInfo;
        this.event=event;
    }

    public CustomEvent(UUID playerUUID, List<UUID> targetUUIDs,int extraInt , String event){
        this(playerUUID,targetUUIDs,extraInt,"",event);
    }
    public CustomEvent(UUID playerUUID, List<UUID> targetUUIDs,String extraInfo , String event){
        this(playerUUID,targetUUIDs,0,extraInfo,event);
    }

    public CustomEvent(UUID playerUUID, List<UUID> targetUUIDs, String event){
        this(playerUUID,targetUUIDs,0,"",event);
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public UUID getPlayerUUID() {
        return playerUUID;
    }

    public List<UUID> getTargetUUIDs() {
        return targetUUIDs;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancel=b;
    }

    public String getEvent() {
        return event;
    }

    public int getExtraInt() {
        return extraInt;
    }

    public String getExtraInfo() {
        return extraInfo;
    }
}

