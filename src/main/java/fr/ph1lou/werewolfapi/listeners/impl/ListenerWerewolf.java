package fr.ph1lou.werewolfapi.listeners.impl;

import fr.ph1lou.werewolfapi.game.WereWolfAPI;
import fr.ph1lou.werewolfapi.utils.BukkitUtils;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

public abstract class ListenerWerewolf implements Listener {

    private final WereWolfAPI game;

    protected boolean register = false;

    public ListenerWerewolf(WereWolfAPI game) {
        this.game = game;
    }

    public boolean isRegister() {
        return this.register;
    }

    public WereWolfAPI getGame(){
        return this.game;
    }

    public void second() {
    }

    public void register(boolean isActive) {

        if (isActive) {
            if (!this.register) {
                BukkitUtils.registerListener(this);
                this.register = true;
            }
        } else if (this.register) {
            HandlerList.unregisterAll(this);
            this.register = false;
        }
    }
}
