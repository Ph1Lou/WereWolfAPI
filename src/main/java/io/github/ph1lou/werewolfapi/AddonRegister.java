package io.github.ph1lou.werewolfapi;

import org.bukkit.plugin.Plugin;

import java.util.*;

/**
 * @author Ph1Lou
 */
@SuppressWarnings("unused")

public class AddonRegister implements RegisterAPI {

    private final String key;

    private final String addonKey;

    private final String defaultLanguage;

    private final Plugin plugin;

    private List<String> lore=new ArrayList<>();

    private final Map<String,UUID> authors = new HashMap<>();

    public AddonRegister(String key, String defaultLanguage, Plugin plugin) {
        this.key=key;
        this.addonKey=key;
        this.defaultLanguage=defaultLanguage;
        this.plugin=plugin;
    }


    public AddonRegister setLore(List<String> lore){
        this.lore=lore;
        return this;
    }

    public AddonRegister setLore(String lore){
        this.lore.add(lore);
        return this;
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public List<String> getLore() {
        return lore;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getAddonKey() {
        return addonKey;
    }

    public Set<String> getAuthorsName() {
        return authors.keySet();
    }

    public AddonRegister addAuthors(String name,UUID uuid) {
        this.authors.put(name,uuid);
        return this;
    }

    public String getDefaultLanguage() {
        return defaultLanguage;
    }

}
