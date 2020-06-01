package io.github.ph1lou.pluginlgapi.events;

import io.github.ph1lou.pluginlgapi.ConfigWereWolfAPI;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.List;
import java.util.UUID;

public class StartEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final ConfigWereWolfAPI configWereWolfAPI;


    public StartEvent(ConfigWereWolfAPI configWereWolfAPI) {
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
