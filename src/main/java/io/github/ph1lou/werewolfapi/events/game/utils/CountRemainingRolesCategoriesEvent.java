package io.github.ph1lou.werewolfapi.events.game.utils;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class CountRemainingRolesCategoriesEvent extends Event {

    private int villager=0;
    private int werewolf=0;
    private int neutral=0;

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public int getVillager() {
        return villager;
    }

    public int getWerewolf() {
        return werewolf;
    }

    public int getNeutral() {
        return neutral;
    }

    public void addVillager() {
        villager++;
    }

    public void addWerewolf() {
        werewolf++;
    }

    public void addNeutral() {
        neutral++;
    }



}

