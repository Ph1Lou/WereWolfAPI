package io.github.ph1lou.werewolfapi;

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
    private List<String> lore=new ArrayList<>();
    private ListenerManager config=null;
    private boolean appearInMenu=true;


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


    public ConfigRegister setLore(List<String> lore){
        this.lore=lore;
        return this;
    }

    public ConfigRegister setLore(String lore){
        this.lore.add(lore);
        return this;
    }

    public List<String> getLore() {
        return lore;
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
}
