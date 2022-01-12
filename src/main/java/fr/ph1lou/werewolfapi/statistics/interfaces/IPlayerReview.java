package fr.ph1lou.werewolfapi.statistics.interfaces;

import java.util.List;
import java.util.UUID;

public interface IPlayerReview {

    UUID getUuid();

    String getName();

    String getRole();

    UUID getAmnesiacLover();

    List<UUID> getLovers();

    UUID getCursedLover();

    int getDeathTime();

    List<UUID> getKillers();

    int getNbKill();

    boolean isInfected();

    boolean isSolitary();
}
