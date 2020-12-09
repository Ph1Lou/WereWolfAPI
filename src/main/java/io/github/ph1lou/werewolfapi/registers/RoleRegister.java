package io.github.ph1lou.werewolfapi.registers;

import io.github.ph1lou.werewolfapi.GetWereWolfAPI;
import io.github.ph1lou.werewolfapi.PlayerWW;
import io.github.ph1lou.werewolfapi.enums.Category;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ph1Lou
 */

public class RoleRegister implements RegisterAPI {

    private final List<Category> categories = new ArrayList<>();

    private final String key;
    private final String addonKey;
    private ItemStack item=null;
    private List<String> loreKey =new ArrayList<>();
    private final Constructor<?> constructors;

    public RoleRegister(String addonKey, String key,Class<?> roleClass) throws NoSuchMethodException {
        this.addonKey=addonKey;
        this.key=key;
        this.constructors=roleClass.getConstructor(GetWereWolfAPI.class, PlayerWW.class, String.class);
    }


    public RoleRegister addCategory(Category category){
        this.categories.add(category);
        return this;
    }

    public RoleRegister setLoreKey(List<String> loreKey){
        this.loreKey = loreKey;
        return this;
    }

    public RoleRegister setLoreKey(String lore){
        this.loreKey.add(lore);
        return this;
    }


    public List<String> getLoreKey() {
        return loreKey;
    }

    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getAddonKey() {
        return addonKey;
    }

    public Constructor<?> getConstructors() {
        return constructors;
    }

    public ItemStack getItem() {
        return item;
    }

    public RoleRegister setItem(ItemStack item) {
        this.item = item;
        return this;
    }

}
