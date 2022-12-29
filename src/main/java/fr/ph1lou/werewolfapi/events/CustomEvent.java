package fr.ph1lou.werewolfapi.events;

import com.google.common.collect.Sets;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public class CustomEvent extends Event implements Cancellable {

    private IPlayerWW playerWW;
    private Set<IPlayerWW> playerWWS;

    private int extraInt = 0;
    private String extraInfo = "";
    private boolean cancel=false;
    private final String event;

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean actionableStory = false;

    public CustomEvent(@NotNull String event){
        this.event = event;
    }

    @Deprecated
    public CustomEvent(IPlayerWW playerWW, @NotNull String extraInfo, @NotNull String event){
        this(playerWW,new HashSet<>(),0,extraInfo,event);
    }

    @Deprecated
    public CustomEvent(IPlayerWW playerWW, int extraInt, @NotNull String event){
        this(playerWW,new HashSet<>(),extraInt,"",event);
    }

    @Deprecated
    public CustomEvent(int extraInt,@NotNull String extraInfo,@NotNull String event){
        this(null,new HashSet<>(),extraInt,extraInfo,event);
    }

    @Deprecated
    public CustomEvent(IPlayerWW playerWW, int extraInt, @NotNull String extraInfo, @NotNull String event){
        this(playerWW,new HashSet<>(),extraInt,extraInfo,event);
    }

    @Deprecated
    public CustomEvent(@Nullable IPlayerWW playerWW, @NotNull Set<IPlayerWW> playerWWS, int extraInt, @NotNull String extraInfo, @NotNull String event){
        this.playerWW = playerWW;
        this.playerWWS = playerWWS;
        this.extraInt = extraInt;
        this.extraInfo = extraInfo;
        this.event = event;
    }

    @Deprecated
    public CustomEvent(@Nullable IPlayerWW playerWW, @NotNull IPlayerWW targetWW, int extraInt, @NotNull String extraInfo, @NotNull String event){
        this(playerWW, Sets.newHashSet(targetWW),extraInt,extraInfo,event);
    }

    @Deprecated
    public CustomEvent(IPlayerWW playerWW, Set<IPlayerWW> playerWWS, int extraInt , String event){
        this(playerWW, playerWWS,extraInt,"",event);
    }

    @Deprecated
    public CustomEvent(IPlayerWW playerWW, Set<IPlayerWW> playerWWS, String extraInfo , String event){
        this(playerWW, playerWWS,0,extraInfo,event);
    }

    @Deprecated
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

    public boolean isActionableStory() {
        return this.actionableStory;
    }

    public CustomEvent setActionableStory(){
        this.actionableStory = true;
        return this;
    }

    public CustomEvent setExtraInt(int extraInt){
        this.extraInt = extraInt;
        return this;
    }

    public CustomEvent setExtraInfo(String extraInfo){
        this.extraInfo = extraInfo;
        return this;
    }

    public CustomEvent setTarget(Set<IPlayerWW> playerWWS){
        this.playerWWS = playerWWS;
        return this;
    }

    public CustomEvent setTarget(IPlayerWW ... playerWW){
        this.playerWWS = Sets.newHashSet(playerWW);
        return this;
    }

    public CustomEvent setPlayer(IPlayerWW playerWW){
        this.playerWW = playerWW;
        return this;
    }
}

