package fr.ph1lou.werewolfapi.registers.impl;

import fr.minuskube.inv.ClickableItem;
import fr.ph1lou.werewolfapi.enums.Category;
import fr.ph1lou.werewolfapi.enums.RandomCompositionAttribute;
import fr.ph1lou.werewolfapi.registers.interfaces.IRegister;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import fr.ph1lou.werewolfapi.game.WereWolfAPI;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

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
    private final List<Function<WereWolfAPI,ClickableItem>> config =new ArrayList<>();
    private final Constructor<?> constructors;

    private RandomCompositionAttribute randomCompositionAttribute=RandomCompositionAttribute.VILLAGER;
    private boolean requireDouble=false;
    private String requireRole="";

    public RoleRegister(String addonKey, String key,Class<?> roleClass) throws NoSuchMethodException {
        this.addonKey=addonKey;
        this.key=key;
        this.constructors=roleClass.getConstructor(WereWolfAPI.class, IPlayerWW.class, String.class);
    }

    public List<? extends String> getLoreKey() {
        return this.loreKey;
    }

    public List<? extends Category> getCategories() {
        return this.categories;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public String getAddonKey() {
        return addonKey;
    }

    public Constructor<?> getConstructors() {
        return this.constructors;
    }

    public RandomCompositionAttribute getRandomCompositionAttribute() {
        return this.randomCompositionAttribute;
    }

    public Optional<ItemStack> getItem() {
        return this.item==null?Optional.empty():Optional.of(this.item);
    }

    public float getWeight() {
        return this.weight;
    }

    public boolean isRequireDouble() {
        return this.requireDouble;
    }

    public Optional<String> getRequireRole() {
        return this.requireRole.isEmpty()?Optional.empty():Optional.of(this.requireRole);
    }

    public List<? extends Function<WereWolfAPI,ClickableItem>> getConfig() {
        return this.config;
    }

    /**
     * Ajoute un attribut au rôle pour la composition automatique
     * @param randomCompositionAttribute l'attribut
     * @return l'instance du register
     */
    public RoleRegister setRandomCompositionAttribute(RandomCompositionAttribute randomCompositionAttribute){
        this.randomCompositionAttribute=randomCompositionAttribute;
        return this;
    }

    /**
     * Le rôle doit être au moins en double dans la composition de la partie
     * @return l'instance du register
     */
    public RoleRegister setRequireDouble(){
        this.requireDouble=true;
        return this;
    }

    /**
     * Le rôle est dépendant d'un autre rôle
     * @param key clef du rôle dépendant
     * @return l'instance du register
     */
    public RoleRegister setRequireAnotherRole(String key){
        this.requireRole=key;
        return this;
    }

    /**
     * Ajoute une catégorie au rôle pour le GUI
     * @param category catégorie
     * @return l'instance du register
     */
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

    /**
     * Change le lore dans le GUI
     * @param loreKey liste des clefs de descriptions
     * @return l'instance du register
     */
    public RoleRegister setLoreKey(List<String> loreKey){
        this.loreKey = loreKey;
        return this;
    }

    /**
     * Ajoute un lore dans le GUI
     * @param lore clef du lore
     * @return l'instance du register
     */
    public RoleRegister addLoreKey(String lore){
        this.loreKey.add(lore);
        return this;
    }

    /**
     * Change l'item dans le GUI
     * @param item l'item
     * @return l'instance du register
     */
    public RoleRegister setItem(ItemStack item) {
        this.item = item;
        return this;
    }

    /**
     * Change le poids du rôle dans le Composition aléatoire
     * @param weight poids
     * @return l'instance du register
     */
    public RoleRegister setWeight(float weight) {
        this.weight = weight;
        return this;
    }

    /**
     * Ajoute un item de config pour ce rôle dans le GUI
     * @param config doit retourner un ClickableItem
     * @return l'instance du register
     */
    public RoleRegister addConfig(Function<WereWolfAPI,ClickableItem> config){
        this.config.add(config);
        return this;
    }
}
