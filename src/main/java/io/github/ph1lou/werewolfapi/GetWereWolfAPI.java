package io.github.ph1lou.werewolfapi;

import fr.minuskube.inv.InventoryManager;
import org.bukkit.plugin.Plugin;

import java.util.Map;

/**
 * @author Ph1Lou
 */

@SuppressWarnings("unused")

public interface GetWereWolfAPI {
    WereWolfAPI getWereWolfAPI();
    RegisterManager getRegisterManager();
    LangManager getLangManager();
    InventoryManager getInvManager();
}