package io.github.ph1lou.werewolfapi;

import fr.minuskube.inv.InventoryManager;

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