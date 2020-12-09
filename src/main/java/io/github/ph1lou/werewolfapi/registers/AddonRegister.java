package io.github.ph1lou.werewolfapi.registers;

import io.github.ph1lou.werewolfapi.ActionItemAddon;
import io.github.ph1lou.werewolfapi.enums.Sounds;
import io.github.ph1lou.werewolfapi.enums.UniversalMaterial;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.*;

/**
 * @author Ph1Lou
 */
@SuppressWarnings("unused")

public class AddonRegister implements RegisterAPI {

    private final String key;

    private List<String> loreKey =new ArrayList<>();

    private ItemStack item= UniversalMaterial.CARROT.getStack();

    private final String defaultLanguage;

    private final Plugin plugin;

    private final Map<String,UUID> authors = new HashMap<>();

    private ActionItemAddon action=(player, previous) -> Sounds.CAT_MEOW.play(player);


    public AddonRegister(String key, String defaultLanguage, Plugin plugin) {
        this.key=key;
        this.defaultLanguage=defaultLanguage;
        this.plugin=plugin;
    }


    public AddonRegister setAction(ActionItemAddon action){
        this.action=action;
        return this;
    }


    public Plugin getPlugin() {
        return plugin;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getAddonKey() {
        return key;
    }

    public AddonRegister addAuthors(String name,UUID uuid) {
        this.authors.put(name,uuid);
        return this;
    }

    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    public Map<String, UUID> getAuthors() {
        return authors;
    }

    public ItemStack getItem() {
        return item;
    }

    public ActionItemAddon getAction() {
        return action;
    }


    public AddonRegister setLoreKey(List<String> loreKey){
        this.loreKey = loreKey;
        return this;
    }

    public AddonRegister addLoreKey(String lore){
        this.loreKey.add(lore);
        return this;
    }

    public List<String> getLoreKey() {
        return loreKey;
    }

    public AddonRegister setItem(ItemStack item) {
        this.item = item;
        return this;
    }



}
