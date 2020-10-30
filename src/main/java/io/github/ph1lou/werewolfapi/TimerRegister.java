package io.github.ph1lou.werewolfapi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ph1Lou
 */
@SuppressWarnings("unused")

public class TimerRegister implements RegisterAPI {

    private final String key;
    private final String addonKey;
    private int defaultValue = 1;
    private List<String> lore=new ArrayList<>();

    public TimerRegister(String addonKey, String key) {
        this.addonKey=addonKey;
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


    public TimerRegister setLore(String lore){
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

}
