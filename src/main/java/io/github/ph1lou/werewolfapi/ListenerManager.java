package io.github.ph1lou.werewolfapi;

import io.github.ph1lou.werewolfapi.utils.BukkitUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public abstract class ListenerManager implements Listener {

    private final GetWereWolfAPI main;

    protected boolean register = false;

    public ListenerManager(GetWereWolfAPI main) {
        this.main = main;
    }

    public boolean isRegister() {
        return this.register;
    }

    public WereWolfAPI getGame(){
        return this.main.getWereWolfAPI();
    }

    public void register(boolean isActive) {

        if (isActive) {
            if (!this.register) {
                BukkitUtils.registerEvents(this);
                this.register = true;
            }
        } else if (this.register) {
            HandlerList.unregisterAll(this);
            this.register = false;
        }
    }
}
