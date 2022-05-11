package fr.ph1lou.werewolfapi.listeners.interfaces;

import fr.ph1lou.werewolfapi.game.WereWolfAPI;



public interface ITimerManager {

    /**
     * When timer value is 0
     * @param wereWolfAPI game
     */
    void consumer(WereWolfAPI wereWolfAPI);

    /**
     * When predicate is true value decrement
     * @param wereWolfAPI game
     * @return the boolean
     */
    default boolean predicate(WereWolfAPI wereWolfAPI){
        return false;
    }
}
