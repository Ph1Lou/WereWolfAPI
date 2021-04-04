package io.github.ph1lou.werewolfapi.registers;

import io.github.ph1lou.werewolfapi.WereWolfAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author Ph1Lou
 */
@SuppressWarnings("unused")

public class TimerRegister implements IRegister {

    private final String key;
    private final String addonKey;
    private int defaultValue = 1;
    private List<String> loreKey =new ArrayList<>();
    private Consumer<WereWolfAPI> consumer = wereWolfAPI -> {};
    private Predicate<WereWolfAPI> predicate=wereWolfAPI -> false;

    public TimerRegister(String addonKey, String key) {
        this.addonKey=addonKey;
        this.key=key;
    }

    public TimerRegister addPredicate(Predicate<WereWolfAPI> predicate){
        this.predicate=predicate;
        return this;
    }

    public int getDefaultValue(){
        return defaultValue;
    }

    public TimerRegister setDefaultValue(int defaultValue){
        this.defaultValue=defaultValue;
        return this;
    }


    public TimerRegister setLoreKey(List<String> loreKey){
        this.loreKey = loreKey;
        return this;
    }


    public TimerRegister addLoreKey(String lore){
        this.loreKey.add(lore);
        return this;
    }

    public List<? extends String> getLoreKey() {
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


    public Predicate<WereWolfAPI> getPredicate() {
        return predicate;
    }


    public Consumer<WereWolfAPI> getConsumer() {
        return consumer;
    }


    public TimerRegister onZero(Consumer<WereWolfAPI> consumer){
        this.consumer =consumer;
        return this;
    }

}
