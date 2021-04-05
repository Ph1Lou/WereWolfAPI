package io.github.ph1lou.werewolfapi.registers;

import io.github.ph1lou.werewolfapi.GetWereWolfAPI;
import io.github.ph1lou.werewolfapi.IPlayerWW;
import io.github.ph1lou.werewolfapi.WereWolfAPI;
import io.github.ph1lou.werewolfapi.enums.Category;
import io.github.ph1lou.werewolfapi.enums.RandomCompositionAttribute;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Ph1Lou
 */

public class RoleRegister implements IRegister {

    private final List<Category> categories = new ArrayList<>();

    private final String key;
    private final String addonKey;
    private float weight=1;
    private ItemStack item=null;
    private List<String> loreKey =new ArrayList<>();
    private final Constructor<?> constructors;

    private RandomCompositionAttribute randomCompositionAttribute=RandomCompositionAttribute.VILLAGER;
    private boolean requireDouble=false;
    private String requireRole="";

    public RoleRegister(String addonKey, String key,Class<?> roleClass) throws NoSuchMethodException {
        this.addonKey=addonKey;
        this.key=key;
        this.constructors=roleClass.getConstructor(WereWolfAPI.class, IPlayerWW.class, String.class);
    }

    public RoleRegister setRandomCompositionAttribute(RandomCompositionAttribute randomCompositionAttribute){
        this.randomCompositionAttribute=randomCompositionAttribute;
        return this;
    }

    public RoleRegister setRequireDouble(){
        this.requireDouble=true;
        return this;
    }

    public RoleRegister setRequireAnotherRole(String key){
        this.requireRole=key;
        return this;
    }


    public RoleRegister addCategory(Category category){
        this.categories.add(category);

        if(this.randomCompositionAttribute.equals(RandomCompositionAttribute.VILLAGER)){
            if(category.equals(Category.WEREWOLF)){
                this.randomCompositionAttribute=RandomCompositionAttribute.WEREWOLF;
            }
            else if(category.equals(Category.NEUTRAL)){
                this.randomCompositionAttribute=RandomCompositionAttribute.NEUTRAL;
            }
        }

        return this;
    }

    public RoleRegister setLoreKey(List<String> loreKey){
        this.loreKey = loreKey;
        return this;
    }

    public RoleRegister addLoreKey(String lore){
        this.loreKey.add(lore);
        return this;
    }


    public List<? extends String> getLoreKey() {
        return loreKey;
    }

    public List<? extends Category> getCategories() {
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

    public RandomCompositionAttribute getRandomCompositionAttribute() {
        return randomCompositionAttribute;
    }

    public Optional<ItemStack> getItem() {
        return this.item==null?Optional.empty():Optional.of(this.item);
    }

    public RoleRegister setItem(ItemStack item) {
        this.item = item;
        return this;
    }

    public float getWeight() {
        return weight;
    }

    public RoleRegister setWeight(float weight) {
        this.weight = weight;
        return this;
    }

    public boolean isRequireDouble() {
        return requireDouble;
    }

    public Optional<String> getRequireRole() {
        return requireRole.isEmpty()?Optional.empty():Optional.of(requireRole);
    }

}
