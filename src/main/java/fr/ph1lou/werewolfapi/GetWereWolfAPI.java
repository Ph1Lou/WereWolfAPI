package fr.ph1lou.werewolfapi;

import fr.minuskube.inv.InventoryManager;
import fr.ph1lou.werewolfapi.game.WereWolfAPI;
import fr.ph1lou.werewolfapi.registers.IRegisterManager;
import fr.ph1lou.werewolfapi.statistics.impl.GameReview;

import java.util.List;

/**
 * @author Ph1Lou
 */

@SuppressWarnings("unused")

public interface GetWereWolfAPI {

    /**
     * Get Current Game
     */
    WereWolfAPI getWereWolfAPI();

    /**
     * Get Register Manager
     */
    IRegisterManager getRegisterManager();

    /**
     * Get SmartInvs Inventory Manager
     */
    InventoryManager getInvManager();

    /**
     * Load Previous Game Stats
     * Not implemented Yet
     */
    List<GameReview> loadPreviousGames();
}