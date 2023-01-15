package fr.ph1lou.werewolfapi.statistics.impl;

import fr.ph1lou.werewolfapi.enums.LoverType;
import fr.ph1lou.werewolfapi.lovers.ILover;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import fr.ph1lou.werewolfapi.statistics.interfaces.IPlayerReview;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PlayerReview implements IPlayerReview {

    private final UUID uuid;
    private final String role;
    private final int deathTime;
    private final List<UUID> killers;
    private final int nbKill;
    private final boolean infected;
    private final boolean solitary;
    private final String name;
    private final boolean winner;
    private final List<UUID> lovers = new ArrayList<>();
    private UUID amnesiacLover = null;
    private UUID cursedLover = null;

    public PlayerReview(IPlayerWW playerWW, boolean winner) {

        this.uuid = playerWW.getReviewUUID();
        this.role = playerWW.getDeathRole();
        this.winner = winner;
        for (ILover ILover : playerWW.getLovers()) {

            List<IPlayerWW> lovers = new ArrayList<>(ILover.getLovers());
            lovers.remove(playerWW);

            if (!lovers.isEmpty()) {

                if (ILover.isKey(LoverType.AMNESIAC_LOVER.getKey())) {
                    this.amnesiacLover = lovers.get(0).getReviewUUID();
                } else if (ILover.isKey(LoverType.CURSED_LOVER.getKey())) {
                    this.cursedLover = lovers.get(0).getReviewUUID();
                } else this.lovers.addAll(lovers.stream().map(IPlayerWW::getReviewUUID).collect(Collectors.toList()));
            }
        }

        this.deathTime = playerWW.getDeathTime();
        this.killers = playerWW.getKillers().stream().map(playerWW1 -> {
            if (playerWW1 == null) {
                return null;
            } else return playerWW1.getReviewUUID();
        }).collect(Collectors.toList());
        this.nbKill = playerWW.getPlayersKills().size();
        this.solitary = playerWW.getRole().isSolitary();
        this.infected = playerWW.getRole().isInfected();
        this.name = playerWW.getName();
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return this.name;
    }

    public String getRole() {
        return role;
    }

    public UUID getAmnesiacLover() {
        return amnesiacLover;
    }

    public List<UUID> getLovers() {
        return lovers;
    }

    public UUID getCursedLover() {
        return cursedLover;
    }

    public int getDeathTime() {
        return deathTime;
    }

    public List<UUID> getKillers() {
        return killers;
    }

    public int getNbKill() {
        return nbKill;
    }

    public boolean isInfected() {
        return infected;
    }

    public boolean isSolitary() {
        return solitary;
    }

    public boolean isWinner() {
        return winner;
    }
}
