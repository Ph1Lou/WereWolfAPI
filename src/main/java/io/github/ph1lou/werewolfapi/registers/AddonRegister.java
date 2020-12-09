package io.github.ph1lou.werewolfapi.registers;

import io.github.ph1lou.werewolfapi.ActionItemAddon;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.*;

/**
 * @author Ph1Lou
 */
@SuppressWarnings("unused")

public class AddonRegister implements RegisterAPI {

    private final String key;

    private final String addonKey;

    private List<String> loreKey =new ArrayList<>();

    private ItemStack item=null;

    private final String defaultLanguage;

    private final Plugin plugin;

    private final Map<String,UUID> authors = new HashMap<>();

    private ActionItemAddon action=null;


    public AddonRegister(String key, String defaultLanguage, Plugin plugin) {
        this.key=key;
        this.addonKey=key;
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
        return addonKey;
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

    public AddonRegister setLoreKey(String lore){
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
