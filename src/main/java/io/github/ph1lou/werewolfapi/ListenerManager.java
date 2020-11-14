package io.github.ph1lou.werewolfapi;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public abstract class ListenerManager implements Listener {

    public final GetWereWolfAPI main;

    private boolean register = false;

    public ListenerManager(GetWereWolfAPI main) {
        this.main = main;
    }

    public boolean isRegister() {
        return register;
    }

    public void register(boolean isActive) {

        if (isActive) {
            if (!register) {
                Bukkit.getPluginManager().registerEvents(this, (Plugin) main);
                register = true;
            }
        } else if (register) {
            HandlerList.unregisterAll(this);
            register = false;
        }
    }

    public void setRegister(boolean register) {
        this.register = register;
    }
}
