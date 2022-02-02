package fr.ph1lou.werewolfapi.statistics.impl;


import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import fr.ph1lou.werewolfapi.game.WereWolfAPI;
import fr.ph1lou.werewolfapi.statistics.interfaces.IGameReview;
import fr.ph1lou.werewolfapi.statistics.interfaces.IPlayerReview;
import fr.ph1lou.werewolfapi.statistics.interfaces.IRegisteredAction;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class GameReview implements IGameReview {

    private final UUID gameUUID;
    private final List<PlayerReview> players = new ArrayList<>();
    private int playersCount;
    private final transient WereWolfAPI api;
    private final List<RegisteredAction> registeredActions = new ArrayList<>();
    private Set<UUID> winners;
    private String winnerCampKey;
    private int duration;
    private String name;
    private final Date date = new Date();
    private final UUID serverUUID;
    private final String pluginVersion;

    public GameReview(WereWolfAPI api, UUID serverUUID) {
        this.api = api;
        this.gameUUID = api.getGameUUID();
        this.serverUUID = serverUUID;
        this.pluginVersion = api.getPluginVersion();
    }

    public void end(String winnerCampKey, Set<IPlayerWW> winners) {
        this.winnerCampKey = winnerCampKey;
        this.winners = winners.stream().map(IPlayerWW::getReviewUUID).collect(Collectors.toSet());
        this.name = api.getGameName();
        for (IPlayerWW playerWW : api.getPlayersWW()) {
            PlayerReview playerReview = new PlayerReview(playerWW, winners.contains(playerWW));
            players.add(playerReview);
        }
        this.duration = api.getTimer();
        this.playersCount = api.getPlayersWW().size();
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

    public int getPlayersCount() {
        return playersCount;
    }

    @Override
    public UUID getServerUUID() {
        return this.serverUUID;
    }

    public Date getDate() {
        return date;
    }
}
