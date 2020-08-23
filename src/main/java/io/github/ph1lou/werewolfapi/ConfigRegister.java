package io.github.ph1lou.werewolfapi;

import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ph1Lou
 */
@SuppressWarnings("unused")

public class ConfigRegister {

    final GetWereWolfAPI api;

    final String key;
    boolean defaultValue = false;
    final Plugin plugin;
    List<String> lore=new ArrayList<>();

    public Plugin getPlugin() {
        return plugin;
    }

    public ConfigRegister(Plugin plugin, GetWereWolfAPI api, String key) {
        this.plugin=plugin;
        this.api= api;
        this.key=key;
    }

    public boolean getDefaultValue(){
        return defaultValue;
    }

    public ConfigRegister setDefaultValue(boolean defaultValue){
        this.defaultValue=defaultValue;
        return this;
    }


    public ConfigRegister setLore(List<String> lore){
        this.lore=lore;
        return this;
    }

    public void create(){
        api.getRegisterConfigs().add(this);
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
