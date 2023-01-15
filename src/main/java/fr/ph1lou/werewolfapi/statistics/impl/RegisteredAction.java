package fr.ph1lou.werewolfapi.statistics.impl;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import fr.ph1lou.werewolfapi.statistics.interfaces.IRegisteredAction;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class RegisteredAction implements IRegisteredAction {


    private final String event;
    @Nullable
    private final UUID uuid;
    @Nullable
    private final UUID gameUuid;
    private final List<UUID> uuidS = new ArrayList<>();
    private final int timer;
    private final String extraInfo;
    private final Integer extraInt;
    private boolean actionableStory = false;

    public RegisteredAction(String event, @Nullable IPlayerWW playerWW, @Nullable Set<IPlayerWW> uuidS, int timer, @Nullable String extraInfo, @Nullable Integer extraInt) {
        this.event = event;
        if (playerWW == null) {
            this.uuid = null;
            this.gameUuid = null;
        } else {
            this.uuid = playerWW.getReviewUUID();
            this.gameUuid = playerWW.getUUID();
        }
        if (uuidS != null) {
            this.uuidS.addAll(uuidS.stream().map(IPlayerWW::getReviewUUID).collect(Collectors.toList()));
        }
        this.timer = timer;
        this.extraInfo = extraInfo;
        this.extraInt = extraInt;
    }

    public String getEvent() {
        return event;
    }

    public @Nullable UUID getUuid() {
        return uuid;
    }

    public List<UUID> getUuidS() {
        return uuidS;
    }

    public int getTimer() {
        return timer;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public Integer getExtraInt() {
        return extraInt;
    }

    @Override
    public @Nullable UUID getGameUuid() {
        return this.gameUuid;
    }

    public boolean isActionableStory() {
        return this.actionableStory;
    }

    public RegisteredAction setActionableStory(boolean actionableStory) {
        this.actionableStory = actionableStory;
        return this;
    }
}
