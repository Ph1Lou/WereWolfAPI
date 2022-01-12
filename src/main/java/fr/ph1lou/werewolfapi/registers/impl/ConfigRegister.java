package fr.ph1lou.werewolfapi.registers.impl;

import fr.ph1lou.werewolfapi.listeners.ListenerManager;
import fr.ph1lou.werewolfapi.registers.interfaces.IRegister;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Ph1Lou
 */
@SuppressWarnings("unused")

public class ConfigRegister implements IRegister {


    private final String key;
    private final String addonKey;
    private boolean defaultValue = false;
    private List<String> loreKey =new ArrayList<>();
    private ListenerManager config=null;
    private boolean appearInMenu=true;
    private final List<String> incompatibleConfigs =new ArrayList<>();
    private ItemStack item=null;


    public ConfigRegister(String addonKey, String key) {
        this.addonKey=addonKey;
        this.key=key;
    }

    public boolean getDefaultValue(){
        return this.defaultValue;
    }

    public List<String> getLoreKey() {
        return this.loreKey;
    }

    @Override
    public String getAddonKey() {
        return addonKey;
    }

    @Override
    public String getKey() {
        return this.key;
    }


    public Optional<ListenerManager> getConfig() {
        return this.config==null?Optional.empty():Optional.of(this.config);
    }

    public boolean isAppearInMenu() {
        return this.appearInMenu;
    }

    public ItemStack getItem() {
        return this.item;
    }

    public List<? extends String> getIncompatibleConfigs() {
        return this.incompatibleConfigs;
    }

    public ConfigRegister addConfig(ListenerManager config) {
        this.config= config;
        return this;
    }

    public ConfigRegister setItem(ItemStack item) {
        this.item = item;
        return this;
    }

    public ConfigRegister addIncompatibleConfig(String key) {
        incompatibleConfigs.add(key);
        return this;
    }

    public ConfigRegister unSetAppearInMenu(){
        appearInMenu=false;
        return this;
    }


    public ConfigRegister setDefaultValue(){
        this.defaultValue=true;
        return this;
    }

    public ConfigRegister setLoreKey(List<String> loreKey){
        this.loreKey = loreKey;
        return this;
    }

    public ConfigRegister setLoreKey(String lore){
        this.loreKey.add(lore);
        return this;
    }

}
