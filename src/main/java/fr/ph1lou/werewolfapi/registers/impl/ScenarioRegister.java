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

public class ScenarioRegister implements IRegister {

    private final String key;
    private final String addonKey;
    private boolean defaultValue = false;
    private ItemStack item=null;
    private List<String> loreKey =new ArrayList<>();

    private final List<String> incompatibleScenarios =new ArrayList<>();

    private final ListenerManager scenario;

    public ScenarioRegister(String addonKey, String key,ListenerManager scenario ) {
        this.addonKey=addonKey;
        this.key=key;
        this.scenario=scenario;
    }

    public boolean getDefaultValue(){
        return defaultValue;
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
        return this.key;
    }

    public ListenerManager getScenario() {
        return this.scenario;
    }

    public Optional<ItemStack> getItem() {
        return this.item==null?Optional.empty():Optional.of(this.item);
    }

    public List<? extends String> getIncompatibleScenarios() {
        return this.incompatibleScenarios;
    }

    /**
     * Change l'item associée au scénario dans le gui
     * @param item l'item
     * @return l'instance du register
     */
    public ScenarioRegister setItem(ItemStack item) {
        this.item = item;
        return this;
    }

    /**
     * Ajoute un scénario incompatible
     * @param key la clef du scénario
     * @return l'instance du register
     */
    public ScenarioRegister addIncompatibleScenario(String key) {
        this.incompatibleScenarios.add(key);
        return this;
    }

    /**
     * Active le scénario par défault
     * @return l'instance du register
     */
    public ScenarioRegister setDefaultValue(){
        this.defaultValue=true;
        return this;
    }

    /**
     * Change la description du scénario dans le GUI
     * @param loreKey clefs des descriptions
     * @return l'instance du register
     */
    public ScenarioRegister setLoreKey(List<String> loreKey){
        this.loreKey = loreKey;
        return this;
    }

    /**
     * Ajoute une description du scénario dans le GUI
     * @param lore clef de la description
     * @return l'instance du register
     */
    public ScenarioRegister addLoreKey(String lore){
        this.loreKey.add(lore);
        return this;
    }
}
