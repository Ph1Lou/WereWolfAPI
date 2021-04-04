package io.github.ph1lou.werewolfapi;

import fr.minuskube.inv.InventoryManager;
import io.github.ph1lou.werewolfapi.registers.IRegisterManager;

/**
 * @author Ph1Lou
 */

@SuppressWarnings("unused")

public interface GetWereWolfAPI {
    WereWolfAPI getWereWolfAPI();
    IRegisterManager getRegisterManager();
    ILanguageManager getLangManager();
    InventoryManager getInvManager();
}