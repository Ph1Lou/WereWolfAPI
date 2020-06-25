package io.github.ph1lou.pluginlgapi;

import io.github.ph1lou.pluginlgapi.enumlg.Day;
import io.github.ph1lou.pluginlgapi.enumlg.StateLG;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * @author Ph1Lou
 */
public interface WereWolfAPI {

    /**
     * Set the name of the game
     * @param name Name of the game
     */

    void setGameName(String name);

    /**
     * Set the hosts of the game
     * @param hostsUUIDs The list of hosts'UUIDs
     */

    void setHosts(List<UUID> hostsUUIDs);

    /**
     * Set the moderators of the game
     * @param moderatorsUUIDs The list of moderators'UUIDs
     */

    void setModerators( List<UUID> moderatorsUUIDs);

    /**
     * Set the White Listed Players of the game
     * @param whiteListedPlayers The list of whitListed players'UUID
     */

    void setWhiteListedPlayers(List<UUID> whiteListedPlayers);

    /**
     * Set the maximum number of players
     * @param playerMax maximum number of players

     */

    void setPlayerMax(int playerMax);


    /**
     * Add a player to the whitelist
     * @param playerName UUID  of the player
     */

    void addPlayerOnWhiteList(UUID playerName);

    /**
     * Remove a player to the whitelist
     * @param playerName UUID of the player
     */

    void removePlayerOnWhiteList(UUID playerName);

    /**
     * Add a host to the game
     * @param hostUUID UUID of the host
     */

    void addHost(UUID hostUUID);

    /**
     * Remove a host to the game
     * @param hostUUID UUID of the host
     */

    void removeHost(UUID hostUUID);

    /**
     * Add a moderator to the game
     * @param moderatorUUID UUID of the moderator
     */

    void addModerator(UUID moderatorUUID);

    /**
     * Remove a moderator to the game
     * @param moderatorUUID UUID of the moderator
     */

    void removeModerator(UUID moderatorUUID);

    /**
     * Generate the map of the concerned game
     * @param mapRadius radius of the map to be generated
     */

    void generateMap(int mapRadius);

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
     * return true if the whitelist is on
     * @return boolean
     */

    boolean isWhiteList();

    /**
     * change the status of the whitelist
     * @param whiteList the desired status
     */

    void setWhiteList(boolean whiteList);

    /**
     * return the maximum of player accepted in the game
     * @return int
     */

    int getPlayerMax();

    /**
     * return the spectator Mode of the game (0 : disable, 1 : for death players, 2: for all players)
     * @return int
     */

    int getSpectatorMode();

    /**
     * change the status of the Spectator Mode
     * @param spectatorMode the desired status (0 : disable, 1 : for death players, 2: for all players)
     */

    void setSpectatorMode(int spectatorMode);

    /**
     * return the Name of the Game
     * @return String
     */

    String getGameName();

    /**
     * return the UUIDs of whitelistedPlayer
     * @return List whitelisted players's UUID
     */

    List<UUID> getWhiteListedPlayers();

    /**
     * return the UUIDs of Hosts
     * @return List hosts's UUID
     */

    List<UUID> getHosts();

    /**
     * return the UUIDs of Moderators
     * @return List moderators's UUID
     */

    List<UUID> getModerators();

    /**
     * return the UUIDs of Players in queue
     * @return List players's UUID
     */

    List<UUID> getQueue();

    /**
     * return the UUIDs of the game
     * @return UUID
     */

    UUID getGameUUID();

    /**
     * delete the game map
     */

    void deleteMap();

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
     * teleport the player around the world
     * @param playerUUID uuid of the player
     * @param d integer between 0 and the players size who corresponds to the angle of the teleportation
     * @param message teleport message
     */

    void transportation(UUID playerUUID, double d, String message);

    /**
     * killed specified player
     * @param uuid uuid of the player
     */

    void death(UUID uuid);

    /**
     * return the time rearranged HH:MM:SS
     * @param timer time in second
     * @return String
     */

    String conversion(int timer);

    /**
     * return the arrow to reach the target location
     * @param player current player
     * @param target target location
     * @return String
     */

    String updateArrow(Player player, Location target);

    Map<String,String> getLanguage();

    Random getRandom();

    UUID autoSelect(UUID playerUUID);

    VoteAPI getVote();

    List<List<UUID>> getLoversRange();

    List<List<UUID>> getAmnesiacLoversRange();

    List<List<UUID>> getCursedLoversRange();

    void updateNameTag();

    void setRoleSize(int roleSize);

    int getRoleSize();

    StuffManager getStuffs();

}
