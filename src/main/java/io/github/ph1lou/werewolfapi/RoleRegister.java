package io.github.ph1lou.werewolfapi;

import io.github.ph1lou.werewolfapi.enumlg.Category;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Ph1Lou
 */

public class RoleRegister implements RegisterAPI {

    private final List<Category> categories = new ArrayList<>();

    private final String key;
    private final String addonKey;
    private List<String> lore=new ArrayList<>();
    private final Constructor<?> constructors;

    public RoleRegister(String addonKey, String key,Class<?> roleClass) throws NoSuchMethodException {
        this.addonKey=addonKey;
        this.key=key;
        this.constructors=roleClass.getConstructor(GetWereWolfAPI.class, WereWolfAPI.class, UUID.class, String.class);
    }


    public RoleRegister addCategory(Category category){
        this.categories.add(category);
        return this;
    }

    public RoleRegister setLore(List<String> lore){
        this.lore=lore;
        return this;
    }


    public List<String> getLore() {
        return lore;
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

}
