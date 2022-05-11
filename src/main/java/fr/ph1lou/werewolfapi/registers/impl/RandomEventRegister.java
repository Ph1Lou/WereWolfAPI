package fr.ph1lou.werewolfapi.registers.impl;

import fr.ph1lou.werewolfapi.listeners.impl.ListenerManager;
import fr.ph1lou.werewolfapi.registers.interfaces.IRegister;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ph1Lou
 */
@SuppressWarnings("unused")

public class RandomEventRegister implements IRegister {


    private final String key;
    private final String addonKey;
    private int defaultValue = 0;
    private List<String> loreKey =new ArrayList<>();
    private final ListenerManager randomEvent;
    private ItemStack item=null;

    public RandomEventRegister(String addonKey, String key, ListenerManager randomEvent) {
        this.addonKey=addonKey;
        this.key=key;
        this.randomEvent=randomEvent;
    }

    public int getDefaultValue(){
        return defaultValue;
    }

    public RandomEventRegister setDefaultValue(int probability){
        this.defaultValue=probability;
        return this;
    }


    public RandomEventRegister setLoreKey(List<String> loreKey){
        this.loreKey = loreKey;
        return this;
    }

    public RandomEventRegister setLoreKey(String lore){
        this.loreKey.add(lore);
        return this;
    }

    public List<String> getLoreKey() {
        return loreKey;
    }

    @Override
    public String getAddonKey() {
        return addonKey;
    }

    @Override
    public String getKey() {
        return key;
    }

    public ListenerManager getRandomEvent() {
        return randomEvent;
    }

    public ItemStack getItem() {
        return item;
    }

    public RandomEventRegister setItem(ItemStack item) {
        this.item = item;
        return this;
    }
}
