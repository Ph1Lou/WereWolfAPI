package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class ElderResurrectionEvent extends ResurrectionEvent {


    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private boolean killerIsVillager;

    public ElderResurrectionEvent(UUID playerUUID, boolean killerIsVillager) {
        super(playerUUID);
        this.killerIsVillager = killerIsVillager;
    }


    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public boolean isKillerAVillager() {
        return killerIsVillager;
    }

    public void setKillerAVillager(boolean killerIsVillager) {
        this.killerIsVillager = killerIsVillager;
    }

}