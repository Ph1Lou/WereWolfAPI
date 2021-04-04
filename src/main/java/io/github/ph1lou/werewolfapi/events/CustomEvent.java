package io.github.ph1lou.werewolfapi.events;

import com.google.common.collect.Sets;
import io.github.ph1lou.werewolfapi.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public class CustomEvent extends Event implements Cancellable {

    private final IPlayerWW playerWW;
    private final Set<IPlayerWW> playerWWS;

    private final int extraInt;
    private final String extraInfo;
    private boolean cancel=false;
    private final String event;

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public CustomEvent(IPlayerWW playerWW, @NotNull String extraInfo, @NotNull String event){
        this(playerWW,new HashSet<>(),0,extraInfo,event);
    }

    public CustomEvent(IPlayerWW playerWW, int extraInt, @NotNull String event){
        this(playerWW,new HashSet<>(),extraInt,"",event);
    }

    public CustomEvent(int extraInt,@NotNull String extraInfo,@NotNull String event){
        this(null,new HashSet<>(),extraInt,extraInfo,event);
    }

    public CustomEvent(IPlayerWW playerWW, int extraInt, @NotNull String extraInfo, @NotNull String event){
        this(playerWW,new HashSet<>(),extraInt,extraInfo,event);
    }

    public CustomEvent(@Nullable IPlayerWW playerWW, @NotNull Set<IPlayerWW> playerWWS, int extraInt, @NotNull String extraInfo, @NotNull String event){
        this.playerWW = playerWW;
        this.playerWWS = playerWWS;
        this.extraInt = extraInt;
        this.extraInfo = extraInfo;
        this.event=event;
    }

    public CustomEvent(@Nullable IPlayerWW playerWW, @NotNull IPlayerWW targetWW, int extraInt, @NotNull String extraInfo, @NotNull String event){
        this(playerWW, Sets.newHashSet(targetWW),extraInt,extraInfo,event);
    }

    public CustomEvent(IPlayerWW playerWW, Set<IPlayerWW> playerWWS, int extraInt , String event){
        this(playerWW, playerWWS,extraInt,"",event);
    }
    public CustomEvent(IPlayerWW playerWW, Set<IPlayerWW> playerWWS, String extraInfo , String event){
        this(playerWW, playerWWS,0,extraInfo,event);
    }

    public CustomEvent(IPlayerWW playerWW, Set<IPlayerWW> playerWWS, String event){
        this(playerWW, playerWWS,0,"",event);
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public IPlayerWW getPlayerWW() {
        return playerWW;
    }

    public Set<IPlayerWW> getPlayerWWS() {
        return playerWWS;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancel=b;
    }

    public String getEvent() {
        return event;
    }

    public int getExtraInt() {
        return extraInt;
    }

    public String getExtraInfo() {
        return extraInfo;
    }
}

