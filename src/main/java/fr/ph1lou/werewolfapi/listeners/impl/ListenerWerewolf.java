package fr.ph1lou.werewolfapi.listeners.impl;

import fr.ph1lou.werewolfapi.enums.StateGame;
import fr.ph1lou.werewolfapi.game.WereWolfAPI;
import fr.ph1lou.werewolfapi.utils.BukkitUtils;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

public abstract class ListenerWerewolf implements Listener {

    private final WereWolfAPI game;

    protected boolean register = false;
    protected boolean wasTriggered = false;

    public ListenerWerewolf(WereWolfAPI game) {
        this.game = game;
    }

    public boolean isRegister() {
        return this.register;
    }

    public boolean wasTriggered() {
        return this.wasTriggered;
    }

    public WereWolfAPI getGame() {
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
            this.wasTriggered = true;
        } else if (this.register) {
            HandlerList.unregisterAll(this);
            this.register = false;
            if (!this.game.isState(StateGame.GAME) && !this.game.isState(StateGame.END)) {
                this.wasTriggered = false;
            }
        }
    }
}
