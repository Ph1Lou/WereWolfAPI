package io.github.ph1lou.werewolfapi.statistics;


import io.github.ph1lou.werewolfapi.PlayerWW;
import io.github.ph1lou.werewolfapi.WereWolfAPI;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class GameReview implements IGameReview {

    private final UUID gameUUID;
    private final List<PlayerReview> players = new ArrayList<>();
    private int playerSize;
    private final transient WereWolfAPI api;
    private final List<RegisteredAction> registeredActions = new ArrayList<>();
    private Set<UUID> winners;
    private String winnerCampKey;
    private int duration;
    private String name;

    public void setServerUUID(UUID serverUUID) {
        this.serverUUID = serverUUID;
    }

    private UUID serverUUID=UUID.randomUUID();

    public GameReview(WereWolfAPI api) {
        this.api = api;
        this.gameUUID = api.getGameUUID();
    }

    public void end(String winnerCampKey, Set<PlayerWW> winners) {
        this.winnerCampKey = winnerCampKey;
        this.winners = winners.stream().map(PlayerWW::getMojangUUID).collect(Collectors.toSet());
        this.name = api.getGameName();
        for (PlayerWW playerWW : api.getPlayerWW()) {
            PlayerReview playerReview = new PlayerReview(playerWW);
            players.add(playerReview);
        }
        this.duration = api.getScore().getTimer();
        this.playerSize = api.getPlayerWW().size();
    }

    public void addRegisteredAction(RegisteredAction registeredAction) {
        this.registeredActions.add(registeredAction);
    }

    public UUID getGameUUID() {
        return gameUUID;
    }

    public Set<UUID> getWinners() {
        return winners;
    }

    public String getWinnerCampKey() {
        return winnerCampKey;
    }

    public List<? extends IPlayerReview> getPlayers() {
        return players;
    }

    public int getDuration() {
        return duration;
    }

    public WereWolfAPI getApi() {
        return api;
    }

    public String getName() {
        return name;
    }

    public List<? extends IRegisteredAction> getRegisteredActions() {
        return registeredActions;
    }

    public int getPlayerSize() {
        return playerSize;
    }

    @Override
    public UUID getServerUUID() {
        return this.serverUUID;
    }

}
