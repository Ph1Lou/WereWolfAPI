package io.github.ph1lou.werewolfapi.registers;

import io.github.ph1lou.werewolfapi.ListenerManager;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ph1Lou
 */
@SuppressWarnings("unused")

public class RandomEventRegister implements RegisterAPI {


    private final String key;
    private final String addonKey;
    private boolean defaultValue = false;
    private List<String> loreKey =new ArrayList<>();
    private ListenerManager randomEvent;
    private ItemStack item=null;
    private final int probability;

    public RandomEventRegister(String addonKey, String key, int probability, ListenerManager randomEvent) {
        this.addonKey=addonKey;
        this.key=key;
        this.probability=probability;
    }

    public RandomEventRegister addConfig(ListenerManager config) {
        this.randomEvent = config;
        return this;

    }

    public boolean getDefaultValue(){
        return defaultValue;
    }

    public RandomEventRegister setDefaultValue(){
        this.defaultValue=true;
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

    @Nullable
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

    public int getProbability() {
        return probability;
    }
}
