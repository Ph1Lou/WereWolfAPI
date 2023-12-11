package fr.ph1lou.werewolfapi.statistics.interfaces;


import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface IGameReview {

    UUID getGameUUID();

    Set<UUID> getWinners();

    String getWinnerCampKey();

    List<? extends IPlayerReview> getPlayers();

    int getDuration();

    String getName();

    List<? extends IRegisteredAction> getRegisteredActions();

    int getPlayersCount();

    UUID getServerUUID();
}
