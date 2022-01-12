package fr.ph1lou.werewolfapi.listeners;

import fr.ph1lou.werewolfapi.GetWereWolfAPI;
import fr.ph1lou.werewolfapi.game.WereWolfAPI;
import fr.ph1lou.werewolfapi.utils.BukkitUtils;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

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
