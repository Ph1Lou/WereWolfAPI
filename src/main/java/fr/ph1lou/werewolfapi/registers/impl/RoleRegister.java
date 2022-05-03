package fr.ph1lou.werewolfapi.registers.impl;

import fr.minuskube.inv.ClickableItem;
import fr.ph1lou.werewolfapi.enums.Category;
import fr.ph1lou.werewolfapi.enums.RoleAttribute;
import fr.ph1lou.werewolfapi.registers.interfaces.IRegister;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import fr.ph1lou.werewolfapi.game.WereWolfAPI;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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

    private final Set<RoleAttribute> attributes = new HashSet<>();
    private boolean requireDouble=false;
    private final Set<String> requireRoles = new HashSet<>();
    private final Set<String> incompatibleRoles = new HashSet<>();

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

    public Set<? extends RoleAttribute> getAttributes() {
        return this.attributes;
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

    public RoleRegister addIncompatibleRole(String key) {
        incompatibleRoles.add(key);
        return this;
    }

    public Set<? extends String> getRequireRoles() {
        return this.requireRoles;
    }

    public List<? extends Function<WereWolfAPI,ClickableItem>> getConfig() {
        return this.config;
    }

    /**
     * Ajoute un attribut au rôle pour la composition automatique
     * @param roleAttribute l'attribut
     * @return l'instance du register
     */
    public RoleRegister addAttribute(RoleAttribute roleAttribute){
        this.attributes.add(roleAttribute);
        return this;
    }

    public Set<? extends String> getIncompatibleRoles() {
        return this.incompatibleRoles;
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
    public RoleRegister addRequireAnotherRole(String key){
        this.requireRoles.add(key);
        return this;
    }

    /**
     * Ajoute une catégorie au rôle pour le GUI
     * @param category catégorie
     * @return l'instance du register
     */
    public RoleRegister addCategory(Category category){
        this.categories.add(category);
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
