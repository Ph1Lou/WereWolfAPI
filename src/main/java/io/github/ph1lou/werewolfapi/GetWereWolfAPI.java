package io.github.ph1lou.werewolfapi;

import fr.minuskube.inv.InventoryManager;
import io.github.ph1lou.werewolfapi.registers.RegisterManager;

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