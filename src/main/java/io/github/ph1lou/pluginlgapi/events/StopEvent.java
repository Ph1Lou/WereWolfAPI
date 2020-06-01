package io.github.ph1lou.pluginlgapi.events;

import io.github.ph1lou.pluginlgapi.ConfigWereWolfAPI;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class StopEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final ConfigWereWolfAPI configWereWolfAPI;


    public StopEvent(ConfigWereWolfAPI configWereWolfAPI) {
        this.configWereWolfAPI=configWereWolfAPI;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public ConfigWereWolfAPI getConfigWereWolfAPI() {
        return configWereWolfAPI;
    }
}
