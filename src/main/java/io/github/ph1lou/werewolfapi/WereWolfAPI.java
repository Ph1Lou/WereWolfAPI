package io.github.ph1lou.werewolfapi;

import io.github.ph1lou.werewolfapi.enums.Day;
import io.github.ph1lou.werewolfapi.enums.StateGame;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * @author Ph1Lou
 */
public interface WereWolfAPI {



    /**
     * Stop the Game
     */

    void stopGame();

    /**
     * Get the game configuration
     * @return ConfigWereWolfAPI
     */

    ConfigWereWolfAPI getConfig();


    /**
     * return true if the state of the game equal the input state
     * @param state state of the game
     * @return boolean
     */

    boolean isState(StateGame state);

    /**
     * return true if the day's game equal the input' game
     * @param day moment of the day's game
     * @return boolean
     */

    boolean isDay(Day day);

    /**
     * return the UUIDs of the game
     * @return UUID
     */

    UUID getGameUUID();

    /**
     * @return Collection the PlayerWW of the game
     */

    Collection<? extends PlayerWW> getPlayerWW();

    /**
     * return the text associated with the key
     * @param key key of the json
     * @param args parameters to format
     * @return String
     */

    String translate(String key, Object... args);

    /**
     * launch the win victory check process
     */

    void checkVictory();

    /**
     * resurrects the player specified
     * @param playerWW the specified player
     */

    void resurrection(PlayerWW playerWW);



    /**
     * killed specified player
     * @param playerWW specified player
     */

    void death(PlayerWW playerWW);

    Optional<PlayerWW> getPlayerWW(UUID uuid);

    Random getRandom();

    PlayerWW autoSelect(PlayerWW playerWW);

    VoteAPI getVote();

    StuffManager getStuffs();

    ScoreAPI getScore();

    MapManagerAPI getMapManager();

    ModerationManagerAPI getModerationManager();

    /**
     * return the Name of the Game
     * @return String
     */

    String getGameName();

    /**
     * Set the name of the game
     * @param name Name of the game
     */

    void setGameName(String name);

    StateGame getState();

    LoverManagerAPI getLoversManager();

}
