package io.github.ph1lou.werewolfapi.registers;

import io.github.ph1lou.werewolfapi.ListenerManager;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Ph1Lou
 */

public class ScenarioRegister implements RegisterAPI {

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

    public ScenarioRegister setDefaultValue(){
        this.defaultValue=true;
        return this;
    }

    public ScenarioRegister setLoreKey(List<String> loreKey){
        this.loreKey = loreKey;
        return this;
    }

    public ScenarioRegister addLoreKey(String lore){
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


    public ListenerManager getScenario() {
        return scenario;
    }


    public Optional<ItemStack> getItem() {
        return this.item==null?Optional.empty():Optional.of(this.item);
    }

    public ScenarioRegister setItem(ItemStack item) {
        this.item = item;
        return this;
    }

    public ScenarioRegister addIncompatibleScenario(String key) {
        incompatibleScenarios.add(key);
        return this;
    }

    public List<? extends String> getIncompatibleScenarios() {
        return incompatibleScenarios;
    }


}
