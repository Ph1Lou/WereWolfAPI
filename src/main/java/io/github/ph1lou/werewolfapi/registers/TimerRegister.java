package io.github.ph1lou.werewolfapi.registers;

import io.github.ph1lou.werewolfapi.WereWolfAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author Ph1Lou
 */
@SuppressWarnings("unused")

public class TimerRegister implements RegisterAPI {

    private final String key;
    private final String addonKey;
    private int defaultValue = 1;
    private List<String> loreKey =new ArrayList<>();
    private Supplier<Void> supplier=null;
    private Predicate<WereWolfAPI> predicate=null;

    public TimerRegister(String addonKey, String key) {
        this.addonKey=addonKey;
        this.key=key;
    }

    public void addPredicate(Predicate<WereWolfAPI> predicate){
        this.predicate=predicate;
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

    public Supplier<Void> getSupplier() {
        return supplier;
    }


    public void onZero(Supplier<Void> supplier){
        this.supplier=supplier;
    }

}
