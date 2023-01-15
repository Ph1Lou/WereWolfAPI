package fr.ph1lou.werewolfapi.statistics.interfaces;


import fr.ph1lou.werewolfapi.game.WereWolfAPI;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface IGameReview {

    UUID getGameUUID();

    Set<UUID> getWinners();

    String getWinnerCampKey();

    List<? extends IPlayerReview> getPlayers();

    int getDuration();

    WereWolfAPI getApi();

    String getName();

    List<? extends IRegisteredAction> getRegisteredActions();

    int getPlayersCount();

    UUID getServerUUID();
}
