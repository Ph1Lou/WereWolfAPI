package io.github.ph1lou.pluginlgapi;

import io.github.ph1lou.pluginlgapi.enumlg.Day;
import io.github.ph1lou.pluginlgapi.enumlg.StateLG;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

import java.util.List;
import java.util.Map;
import java.util.UUID;

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
     * Get the game config
     * @return ConfigWereWolfAPI
     */

    ConfigWereWolfAPI getConfig();

    boolean isState(StateLG state);

    boolean isDay(Day day);

    boolean isWhiteList();

    void setWhiteList(boolean whiteList);

    int getPlayerMax();

    int getSpectatorMode();

    void setSpectatorMode(int spectatorMode);

    String getGameName();

    List<UUID> getWhiteListedPlayers();

    List<UUID> getHosts();

    List<UUID> getModerators();

    List<UUID> getQueue();

    UUID getGameUUID();

    void deleteMap();

    Scoreboard getWereWolfScoreBoard();

    Map<UUID,PlayerWW> getPlayersWW();

    String translate(String key, Object... args);

    void checkVictory();

    void resurrection(UUID uuid);

    void transportation(UUID playerUUID, double d, String message);

    void death(UUID uuid);

    String conversion(int timer);

    String updateArrow(Player player, Location target);
}
