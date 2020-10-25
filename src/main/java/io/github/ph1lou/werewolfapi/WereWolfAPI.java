package io.github.ph1lou.werewolfapi;

import io.github.ph1lou.werewolfapi.enumlg.Day;
import io.github.ph1lou.werewolfapi.enumlg.StateLG;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

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

    boolean isState(StateLG state);

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
     * return the Map of players uuid key with PlayerWW class
     * @return Map game's players
     */

    Map<UUID,PlayerWW> getPlayersWW();

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
     * @param uuid uuid of the player
     */

    void resurrection(UUID uuid);



    /**
     * killed specified player
     * @param uuid uuid of the player
     */

    void death(UUID uuid);

    @Nullable
    PlayerWW getPlayerWW(UUID uuid);

    Map<String,String> getLanguage();

    Random getRandom();

    UUID autoSelect(UUID playerUUID);

    VoteAPI getVote();

    List<List<UUID>> getLoversRange();

    List<List<UUID>> getAmnesiacLoversRange();

    List<List<UUID>> getCursedLoversRange();

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

}
