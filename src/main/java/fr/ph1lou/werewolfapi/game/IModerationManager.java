package fr.ph1lou.werewolfapi.game;

import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public interface IModerationManager {

    /**
     * Add a player to the whitelist
     *
     * @param playerName UUID  of the player
     */

    void addPlayerOnWhiteList(UUID playerName);

    /**
     * Remove a player to the whitelist
     *
     * @param playerName UUID of the player
     */

    void removePlayerOnWhiteList(UUID playerName);

    /**
     * Add a host to the game
     *
     * @param hostUUID UUID of the host
     */

    void addHost(UUID hostUUID);

    /**
     * Remove a host to the game
     *
     * @param hostUUID UUID of the host
     */

    void removeHost(UUID hostUUID);

    /**
     * Add a moderator to the game
     *
     * @param moderatorUUID UUID of the moderator
     */

    void addModerator(UUID moderatorUUID);

    /**
     * Remove a moderator to the game
     *
     * @param moderatorUUID UUID of the moderator
     */

    void removeModerator(UUID moderatorUUID);

    /**
     * return the UUIDs of whitelistedPlayer
     *
     * @return List whitelisted players's UUID
     */

    List<? extends UUID> getWhiteListedPlayers();

    /**
     * Set the White Listed Players of the game
     *
     * @param whiteListedPlayers The list of whitListed players'UUID
     */

    void setWhiteListedPlayers(List<UUID> whiteListedPlayers);

    /**
     * return the UUIDs of Hosts
     *
     * @return List hosts's UUID
     */

    List<? extends UUID> getHosts();

    /**
     * Set the hosts of the game
     *
     * @param hostsUUIDs The list of hosts'UUIDs
     */

    void setHosts(List<UUID> hostsUUIDs);

    /**
     * return the UUIDs of Moderators
     *
     * @return List moderators's UUID
     */

    List<? extends UUID> getModerators();

    /**
     * Set the moderators of the game
     *
     * @param moderatorsUUIDs The list of moderators'UUIDs
     */

    void setModerators(List<UUID> moderatorsUUIDs);

    /**
     * return the UUIDs of Players in queue
     *
     * @return List players's UUID
     */

    List<? extends UUID> getQueue();

    void checkQueue();

    void alertHostsAndModerators(String message);

    void alertHosts(String message);

    void alertModerators(String message);

    boolean isStaff(UUID uuid);

    boolean checkAccessAdminCommand(String commandKey, Player player);

    boolean checkAccessAdminCommand(String commandKey, Player player, boolean seePermissionMessages);
}
