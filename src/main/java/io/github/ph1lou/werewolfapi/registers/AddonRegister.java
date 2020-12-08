package io.github.ph1lou.werewolfapi.registers;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import io.github.ph1lou.werewolfapi.ActionItemAddon;
import io.github.ph1lou.werewolfapi.GetWereWolfAPI;
import io.github.ph1lou.werewolfapi.WereWolfAPI;
import io.github.ph1lou.werewolfapi.enums.UniversalMaterial;
import io.github.ph1lou.werewolfapi.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
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

    private final ItemStack item;

    private final String defaultLanguage;

    private final Plugin plugin;

    private final Map<String,UUID> authors = new HashMap<>();

    private ActionItemAddon action;


    public AddonRegister(String key, String defaultLanguage, Plugin plugin,ItemStack item, ActionItemAddon action) {
        this.key=key;
        this.addonKey=key;
        this.defaultLanguage=defaultLanguage;
        this.plugin=plugin;
        this.item=item;
        this.action=action;
    }

    public AddonRegister(String key, String defaultLanguage, Plugin plugin){
        this(key,defaultLanguage,plugin,UniversalMaterial.CRAFTING_TABLE.getStack());
    }

    public AddonRegister(String key, String defaultLanguage, Plugin plugin,ItemStack item){
        this(key,defaultLanguage,plugin,item,null);

        this.action= player -> SmartInventory.builder()
                .id(key)
                .manager(((GetWereWolfAPI) Bukkit.getPluginManager().getPlugin("WereWolfPlugin")).getInvManager())
                .provider(new MenuAddonDefault())
                .size(4, 9)
                .title(((GetWereWolfAPI) Bukkit.getPluginManager().getPlugin("WereWolfPlugin")).getLangManager().getExtraTexts().get(key))
                .closeable(true)
                .build().open(player);
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

    public class MenuAddonDefault implements InventoryProvider {


        @Override
        public void init(Player player, InventoryContents contents) {

            GetWereWolfAPI main = ((GetWereWolfAPI) Bukkit.getPluginManager().getPlugin("WereWolfPlugin"));
            WereWolfAPI game = main.getWereWolfAPI();
            int i=0;

            for(String name :getAuthors().keySet()){
                contents.set(i/9, i%9, ClickableItem.empty(new ItemBuilder(UniversalMaterial.PLAYER_HEAD.getStack()).setHead(name , Bukkit.getOfflinePlayer(getAuthors().get(name))).setDisplayName(name).build()));
                i++;
            }
            //contents.set(0, 0, ClickableItem.of((new ItemBuilder(UniversalMaterial.COMPASS.getType()).setDisplayName(game.translate("werewolf.menu.return")).build()), e -> Config.INVENTORY.open(player)));
        }


    }


}
