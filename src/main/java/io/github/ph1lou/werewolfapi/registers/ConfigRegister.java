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

public class ConfigRegister implements RegisterAPI {


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

    public ConfigRegister addConfig(ListenerManager config) {
        this.config= config;
        return this;

    }

    public boolean getDefaultValue(){
        return defaultValue;
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
    public ListenerManager getConfig() {
        return config;
    }

    public ConfigRegister unSetAppearInMenu(){
        appearInMenu=false;
        return this;
    }

    public boolean isAppearInMenu() {
        return appearInMenu;
    }

    public ItemStack getItem() {
        return item;
    }

    public ConfigRegister setItem(ItemStack item) {
        this.item = item;
        return this;
    }

    public ConfigRegister addIncompatibleConfig(String key) {
        incompatibleConfigs.add(key);
        return this;
    }

    public List<? extends String> getIncompatibleConfigs() {
        return incompatibleConfigs;
    }
}
