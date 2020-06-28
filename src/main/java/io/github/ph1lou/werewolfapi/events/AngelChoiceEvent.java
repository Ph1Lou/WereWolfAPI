package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.enumlg.AngelForm;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

public class AngelChoiceEvent extends Event {

    private final UUID playerUUID;
    private final AngelForm choice;

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public AngelChoiceEvent(UUID playerUUID, AngelForm choice){
        this.playerUUID =playerUUID;
        this.choice = choice;
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

    public AngelForm getChoice() {
        return choice;
    }
}

