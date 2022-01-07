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

    /**
     * Chaque seconde, le prédicat est testé, si il est validé, le timer décroit de 1
     * @param predicate le prédicat
     * @return l'instance du register
     */
    public TimerRegister addPredicate(Predicate<WereWolfAPI> predicate){
        this.predicate=predicate;
        return this;
    }

    /**
     * Définit la valeur par défaut du timer
     * @param defaultValue la valeur du timer
     * @return l'instance du register
     */
    public TimerRegister setDefaultValue(int defaultValue){
        this.defaultValue=defaultValue;
        return this;
    }

    /**
     * Change le lore dans le GUI
     * @param loreKey liste des clefs de descriptions
     * @return l'instance du register
     */
    public TimerRegister setLoreKey(List<String> loreKey){
        this.loreKey = loreKey;
        return this;
    }

    /**
     * Ajoute un lore dans le GUI
     * @param lore clef du lore
     * @return l'instance du register
     */
    public TimerRegister addLoreKey(String lore){
        this.loreKey.add(lore);
        return this;
    }

    /**
     * Le consumer est appelé quand le timer vaut 0
     * @param consumer le consumer appelé
     * @return l'instance du register
     */
    public TimerRegister onZero(Consumer<WereWolfAPI> consumer){
        this.consumer =consumer;
        return this;
    }

    public int getDefaultValue(){
        return defaultValue;
    }



    public List<? extends String> getLoreKey() {
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

    public Predicate<WereWolfAPI> getPredicate() {
        return this.predicate;
    }

    public Consumer<WereWolfAPI> getConsumer() {
        return this.consumer;
    }
}
