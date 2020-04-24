import java.util.List;
import java.util.UUID;

public interface WereWolfAPI {

    /**
     * Launch a game
     * @param hostsUUIDs The list of hosts'UUIDs
     * @param moderatorsUUIDs The list of moderators'UUIDs
     * @param whiteListedPlayers The list of whitListed players'names
     * @param playerMax maximum number of players
     * @return UUID of the create game
     */

    UUID launchGame(List<UUID> hostsUUIDs, List<UUID> moderatorsUUIDs, List<String> whiteListedPlayers, int playerMax);

    /**
     * Adds a player to the whitelist
     * @param gameUUID UUID of the concerned game
     * @param playerName Name of the player
     * @return void
     */

    void addPlayerOnWhiteList(UUID gameUUID,String playerName);

    /**
     * Removes a player to the whitelist
     * @param gameUUID UUID of the concerned game
     * @param playerName Name of the player
     * @return void
     */

    void removePlayerOnWhiteList(UUID gameUUID,String playerName);

    /**
     * Adds a host to the game
     * @param gameUUID UUID of the concerned game
     * @param hostUUID UUID of the host
     * @return void
     */

    void addHost(UUID gameUUID,UUID hostUUID);

    /**
     * Removes a host to the game
     * @param gameUUID UUID of the concerned game
     * @param hostUUID UUID of the host
     * @return void
     */

    void removeHost(UUID gameUUID,UUID hostUUID);

    /**
     * Adds a moderator to the game
     * @param gameUUID UUID of the concerned game
     * @param moderatorUUID UUID of the moderator
     * @return void
     */

    void addModerator(UUID gameUUID,UUID moderatorUUID);

    /**
     * Removes a moderator to the game
     * @param gameUUID UUID of the concerned game
     * @param moderatorUUID UUID of the moderator
     * @return void
     */

    void removeModerator(UUID gameUUID,UUID moderatorUUID);

    /**
     * Generate the map of the concerned game
     * @param gameUUID UUID of the concerned game
     * @param mapRadius radius of the map to be generated
     * @return void
     */

    void generateMap(UUID gameUUID,int mapRadius);
}
