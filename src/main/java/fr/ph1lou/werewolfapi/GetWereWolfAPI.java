package fr.ph1lou.werewolfapi;

import fr.minuskube.inv.InventoryManager;
import fr.ph1lou.werewolfapi.registers.interfaces.IRegisterManager;
import fr.ph1lou.werewolfapi.statistics.impl.GameReview;
import fr.ph1lou.werewolfapi.game.WereWolfAPI;

import java.util.List;
import java.util.Optional;

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
     * Get Register Manager for a specific addon
     * @param addonKey of the addon
     */
    Optional<IRegisterManager> getAddonRegisterManager(String addonKey);

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