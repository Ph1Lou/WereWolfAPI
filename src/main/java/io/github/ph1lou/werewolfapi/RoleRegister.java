package io.github.ph1lou.werewolfapi;

import io.github.ph1lou.werewolfapi.enumlg.Category;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Ph1Lou
 */

public class RoleRegister {

    final GetWereWolfAPI api;

    final List<Category> categories = new ArrayList<>();

    final String key;

    final Plugin plugin;
    List<String> lore=new ArrayList<>();

    Constructor<?> constructors= null;


    public Plugin getPlugin() {
        return plugin;
    }

    public RoleRegister(Plugin plugin,GetWereWolfAPI api, String key) {
        this.plugin=plugin;
        this.api= api;
        this.key=key;
    }

    public RoleRegister registerRole(Class<?> roleClass) throws NoSuchMethodException {
        this.constructors=roleClass.getConstructor(GetWereWolfAPI.class, WereWolfAPI.class, UUID.class);
        return this;
    }

    public RoleRegister addCategory(Category category){
        this.categories.add(category);
        return this;
    }

    public RoleRegister setLore(List<String> lore){
        this.lore=lore;
        return this;
    }

    public void create(){
        if(constructors==null) return;
        api.getRegisterRoles().add(this);
    }

    public List<String> getLore() {
        return lore;
    }

    public String getName() {
        return api.getWereWolfAPI().translate(key);
    }

    public List<Category> getCategories() {
        return categories;
    }

    public String getKey() {
        return key;
    }

    public Constructor<?> getConstructors() {
        return constructors;
    }

}
