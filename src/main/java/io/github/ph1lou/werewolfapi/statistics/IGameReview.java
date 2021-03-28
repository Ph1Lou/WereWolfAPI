package io.github.ph1lou.werewolfapi.statistics;


import io.github.ph1lou.werewolfapi.WereWolfAPI;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface IGameReview {

     UUID getGameUUID();

     Set<UUID> getWinners() ;

     String getWinnerCampKey();

     List<? extends IPlayerReview> getPlayers();

     int getDuration();

     WereWolfAPI getApi();

     String getName();

     List<? extends IRegisteredAction> getRegisteredActions();

     int getPlayerSize();

     UUID getServerUUID();
}
