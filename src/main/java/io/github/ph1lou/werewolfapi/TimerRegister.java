package io.github.ph1lou.werewolfapi;

import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ph1Lou
 */
@SuppressWarnings("unused")

public class TimerRegister {

    final GetWereWolfAPI api;

    final String key;
    int defaultValue = 1;
    final Plugin plugin;
    List<String> lore=new ArrayList<>();

    public Plugin getPlugin() {
        return plugin;
    }

    public TimerRegister(Plugin plugin, GetWereWolfAPI api, String key) {
        this.plugin=plugin;
        this.api= api;
        this.key=key;
    }

    public int getDefaultValue(){
        return defaultValue;
    }

    public TimerRegister setDefaultValue(int defaultValue){
        this.defaultValue=defaultValue;
        return this;
    }


    public TimerRegister setLore(List<String> lore){
        this.lore=lore;
        return this;
    }

    public void create(){
        api.getRegisterTimers().add(this);
    }

    public List<String> getLore() {
        return lore;
    }

    public String getName() {
        return api.getWereWolfAPI().translate(key);
    }

    public String getKey() {
        return key;
    }

}
