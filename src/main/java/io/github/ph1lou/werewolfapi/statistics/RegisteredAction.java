package io.github.ph1lou.werewolfapi.statistics;

import com.google.common.collect.Sets;
import io.github.ph1lou.werewolfapi.IPlayerWW;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class RegisteredAction implements IRegisteredAction {


    private final String event;
    @Nullable
    private final UUID uuid;

    private final List<UUID> uuidS = new ArrayList<>();
    private final int timer;
    private String extraInfo;
    private int extraInt;

    public RegisteredAction(String event, @Nullable IPlayerWW playerWW, Set<IPlayerWW> uuidS, int timer) {
        this.event = event;
        if (playerWW == null) {
            this.uuid = null;
        } else this.uuid = playerWW.getMojangUUID();
        if (uuidS != null) {
            this.uuidS.addAll(uuidS.stream().map(io.github.ph1lou.werewolfapi.IPlayerWW::getMojangUUID).collect(Collectors.toList()));
        }
        this.timer = timer;
    }

    public RegisteredAction(@NotNull String event, @Nullable IPlayerWW playerWW, @Nullable IPlayerWW targetWW, int timer) {
        this(event, playerWW, targetWW == null ? new HashSet<>() : Sets.newHashSet(targetWW), timer);
    }

    public RegisteredAction(@NotNull String event, @Nullable IPlayerWW playerWW, int timer) {
        this(event, playerWW, new HashSet<>(), timer);
    }

    public RegisteredAction(@NotNull String event, @NotNull Set<IPlayerWW> playerWWS, int timer) {
        this(event, null, playerWWS, timer);
    }

    public RegisteredAction(@NotNull String event, @NotNull Set<IPlayerWW> playerWWS, int timer, @NotNull String extraInfo) {
        this(event, null, playerWWS, timer, extraInfo);
    }

    public RegisteredAction(@NotNull String event, @Nullable IPlayerWW playerWW, @NotNull Set<IPlayerWW> playerWWS, int timer, @NotNull String extraInfo) {
        this(event, playerWW, playerWWS, timer);
        this.extraInfo = extraInfo;
    }

    public RegisteredAction(@NotNull String event, @Nullable IPlayerWW playerWW, int timer, @NotNull String extraInfo) {
        this(event, playerWW, new HashSet<>(), timer);
        this.extraInfo = extraInfo;
    }

    public RegisteredAction(@NotNull String event, @Nullable IPlayerWW playerWW, int timer, int extraInt) {
        this(event, playerWW, new HashSet<>(), timer);
        this.extraInt = extraInt;
    }

    public RegisteredAction(@NotNull String event, int timer, @NotNull String extraInfo) {
        this(event, (IPlayerWW) null, timer, extraInfo);
    }

    public RegisteredAction(@NotNull String event, int timer, int extraInt) {
        this(event, null, timer, extraInt);
    }

    public RegisteredAction(@NotNull String event, @Nullable IPlayerWW playerWW, @Nullable IPlayerWW targetWW, int timer, @NotNull String extraInfo) {
        this(event, playerWW, Sets.newHashSet(targetWW), timer);
        this.extraInfo = extraInfo;
    }

    public RegisteredAction(@NotNull String event, @Nullable IPlayerWW playerWW, @Nullable IPlayerWW targetWW, int timer, int extraInt) {
        this(event, playerWW, Sets.newHashSet(targetWW), timer);
        this.extraInt = extraInt;
    }

    public RegisteredAction(@NotNull String event, @Nullable IPlayerWW playerWW, @Nullable IPlayerWW targetWW, int timer, @NotNull String extraInfo, int extraInt) {
        this(event, playerWW, targetWW, timer);
        this.extraInfo = extraInfo;
        this.extraInt = extraInt;
    }

    public RegisteredAction(@NotNull String event, @Nullable IPlayerWW playerWW, @NotNull Set<IPlayerWW> playerWWS, int timer, @NotNull String extraInfo, int extraInt) {
        this(event, playerWW, playerWWS, timer);
        this.extraInfo = extraInfo;
        this.extraInt = extraInt;
    }

    public RegisteredAction(@NotNull String event, int timer) {
        this(event, null, new HashSet<>(), timer);
    }

    public RegisteredAction(@NotNull String event, @Nullable IPlayerWW playerWW, @NotNull Set<IPlayerWW> playerWWS, int timer, int extraInt) {
        this(event, playerWW, playerWWS, timer);
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

    public int getExtraInt() {
        return extraInt;
    }
}
