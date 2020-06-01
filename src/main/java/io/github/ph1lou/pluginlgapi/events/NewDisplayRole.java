package io.github.ph1lou.pluginlgapi.events;

import io.github.ph1lou.pluginlgapi.enumlg.Camp;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

public class NewDisplayRole extends Event {

    private final UUID playerUUID;
    private final String newDisplayRole;
    private final Camp newDisplayCamp;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public NewDisplayRole(UUID playerUUID, String newDisplayRole1, Camp newDisplayCamp){
        this.playerUUID =playerUUID;
        this.newDisplayRole = newDisplayRole1;

        this.newDisplayCamp = newDisplayCamp;
    }

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


    public Camp getNewDisplayCamp() {
        return newDisplayCamp;
    }

    public String getNewDisplayRole() {
        return newDisplayRole;
    }
}

