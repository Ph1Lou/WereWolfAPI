package io.github.ph1lou.werewolfapi;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ph1Lou
 */

public class ScenarioRegister implements RegisterAPI {

    private final String key;
    private final String addonKey;
    private boolean defaultValue = false;
    private List<String> lore=new ArrayList<>();

    private final Constructor<?> constructors;


    public ScenarioRegister(String addonKey, String key,Class<?> scenarioClass ) throws NoSuchMethodException {
        this.addonKey=addonKey;
        this.key=key;
        this.constructors=scenarioClass.getConstructor(GetWereWolfAPI.class, WereWolfAPI.class, String.class);
    }


    public boolean getDefaultValue(){
        return defaultValue;
    }

    public ScenarioRegister setDefaultValue(){
        this.defaultValue=true;
        return this;
    }

    public ScenarioRegister setLore(List<String> lore){
        this.lore=lore;
        return this;
    }

    public ScenarioRegister setLore(String lore){
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

    public Constructor<?> getConstructors() {
        return constructors;
    }

}
