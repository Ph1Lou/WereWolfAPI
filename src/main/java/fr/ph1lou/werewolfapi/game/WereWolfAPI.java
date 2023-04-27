package fr.ph1lou.werewolfapi.game;

import fr.ph1lou.werewolfapi.enums.Day;
import fr.ph1lou.werewolfapi.enums.StateGame;
import fr.ph1lou.werewolfapi.lovers.ILoverManager;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import fr.ph1lou.werewolfapi.player.utils.Formatter;
import fr.ph1lou.werewolfapi.vote.IVoteManager;

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
     *
     * @return ConfigWereWolfAPI
     */

    IConfiguration getConfig();


    /**
     * return true if the state of the game equal the input state
     *
     * @param state state of the game
     * @return boolean
     */

    boolean isState(StateGame state);

    /**
     * return true if the day's game equal the input' game
     *
     * @param day moment of the day's game
     * @return boolean
     */

    boolean isDay(Day day);

    /**
     * return the UUIDs of the game
     *
     * @return UUID
     */

    UUID getGameUUID();

    /**
     * @return Collection the PlayerWW of the game
     */

    Collection<? extends IPlayerWW> getPlayersWW();

    /**
     * return the text associated with the key
     *
     * @param key  key of the json
     * @param args parameters to format
     * @return String
     */

    String translate(String key, Formatter... args);

    /**
     * return the text associated with the key
     *
     * @param prefixKey key of the json
     * @param key       key of the json
     * @param args      parameters to format
     * @return String
     */

    String translate(String prefixKey, String key, Formatter... args);

    /**
     * launch the win victory check process
     */

    void checkVictory();

    /**
     * resurrects the player specified
     *
     * @param playerWW the specified player
     */

    void resurrection(IPlayerWW playerWW);


    /**
     * killed specified player
     *
     * @param playerWW specified player
     */

    void death(IPlayerWW playerWW);

    /**
     * allow to get playerww with uuid
     *
     * @param uuid uuid of the player
     * @return the instance of playerWW
     */
    Optional<IPlayerWW> getPlayerWW(UUID uuid);

    /**
     * Get Random Generator of the game
     *
     * @return the random generator
     */
    Random getRandom();

    /**
     * Get Vote Manager
     *
     * @return Vote Manager
     */
    IVoteManager getVoteManager();

    /**
     * Set Vote Manager
     */

    void setVoteManager(IVoteManager voteManager);

    /**
     * Translate a key array
     *
     * @param key  associated with json
     * @param args the formatters
     * @return a string translated array
     */
    List<String> translateArray(String key, Formatter... args);

    /**
     * Get Stuff Manager
     *
     * @return Stuff Manager
     */
    IStuffManager getStuffs();

    /**
     * Get Map Manager
     *
     * @return the Map Manager
     */
    IMapManager getMapManager();

    /**
     * Get Moderation Manager
     *
     * @return the Moderation Manager
     */
    IModerationManager getModerationManager();

    /**
     * return the Name of the Game
     *
     * @return String
     */

    String getGameName();

    /**
     * Set the name of the game
     *
     * @param name Name of the game
     */

    void setGameName(String name);

    /**
     * Get the game's state
     *
     * @return game'state
     */
    StateGame getState();

    /**
     * Get Lover Manager
     *
     * @return Lover Manager
     */
    ILoverManager getLoversManager();

    /**
     * Get Alive Player Count
     *
     * @return player's alive count
     */
    int getPlayersCount();

    /**
     * Get Group SIze
     *
     * @return the size
     */
    int getGroup();

    /**
     * Change Group Size
     *
     * @param group the size
     */
    void setGroup(int group);

    /**
     * Get Timer
     *
     * @return the timer
     */
    int getTimer();

    /**
     * Get Role initial size
     *
     * @return the role initial size
     */
    int getRoleInitialSize();

    IWerewolfChatHandler getWerewolfChatHandler();

    String getPluginVersion();

    String getLanguage();

    void setLangage(String language);

    ILanguageManager getLanguageManager();

    IListenersManager getListenersManager();

    void addScheduleId(int idSchedule);

    IScoreboard getScoreboard();
}
