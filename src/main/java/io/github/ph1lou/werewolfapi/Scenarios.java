package io.github.ph1lou.werewolfapi;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public abstract class Scenarios implements Listener {
    public final GetWereWolfAPI main;
    public final WereWolfAPI game;
    public final String scenarioID;
    public boolean register = false;

    public Scenarios(GetWereWolfAPI main, WereWolfAPI game, String scenarioID) {
        this.main = main;
        this.game=game;
        this.scenarioID =scenarioID;
    }


    public void register() {
        if (game.getConfig().getScenarioValues().get(scenarioID)) {
            if (!register) {
                Bukkit.getPluginManager().registerEvents(this, (Plugin) main);
                register = true;
            }
        } else {
            if (register) {
                HandlerList.unregisterAll(this);
                register = false;
            }
        }
    }
}
