package io.github.ph1lou.werewolfapi;

import io.github.ph1lou.werewolfapi.enums.Day;
import io.github.ph1lou.werewolfapi.enums.StateGame;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
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

    IConfiguration getConfig();


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

    Collection<? extends IPlayerWW> getPlayersWW();

    /**
     * @deprecated use Formatter
     * return the text associated with the key
     * @param key key of the json
     * @param args parameters to format
     * @return String
     */
    @Deprecated
    String translate(String key, Object... args);



    /**
     * return the text associated with the key
     * @param key key of the json
     * @param args parameters to format
     * @return String
     */

    String translate(String key, Formatter... args);

    /**
     * launch the win victory check process
     */

    void checkVictory();

    /**
     * resurrects the player specified
     * @param playerWW the specified player
     */

    void resurrection(IPlayerWW playerWW);



    /**
     * killed specified player
     * @param playerWW specified player
     */

    void death(IPlayerWW playerWW);


    /**
     * allow to get playerww with uuid
     * @param uuid uuid of the player
     * @return the instance of playerWW
     */
    Optional<IPlayerWW> getPlayerWW(UUID uuid);

    /**
     * Get Random Generator of the game
     * @return the random generator
     */
    Random getRandom();

    /**
     * Select a random Player who should be alive
     * @param playerWW the requester
     * @return a random player or the requester if no-player was found
     */
    IPlayerWW autoSelect(IPlayerWW playerWW);

    /**
     * Get Vote Manager
     * @return Vote Manager
     */
    IVoteManager getVote();

    /**
     * Translate a key array
     * @param key associated with json
     * @param args the formatters
     * @return a string translated array
     */
    List<String> translateArray(String key, Formatter... args);

    /**
     * Get Stuff Manager
     * @return Stuff Manager
     */
    IStuffManager getStuffs();

    /**
     * Get ScoreBoard Manager
     * @return the ScoreBoard Manager
     */
    IScoreBoard getScore();

    /**
     * Get Map Manager
     * @return the Map Manager
     */
    IMapManager getMapManager();

    /**
     * Get Moderation Manager
     * @return the Moderation Manager
     */
    IModerationManager getModerationManager();

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

    /**
     * Get the game's state
     * @return game'state
     */
    StateGame getState();

    /**
     * Get Lover Manager
     * @return Lover Manager
     */
    ILoverManager getLoversManager();

    /**
     * Get Alive Player Size
     * @return player's alive size
     */
    int getPlayerSize();

    /**
     * Get Group SIze
     * @return the size
     */
    int getGroup();

    /**
     * Change Group Size
     * @param group the size
     */
    void setGroup(int group);

    /**
     * Get Timer
     * @return the timer
     */
    int getTimer();

    /**
     * Get Role initial size
     * @return the role initial size
     */
    int getRoleInitialSize();

    void enableWereWolfChat();

    void disableWereWolfChat();
}
