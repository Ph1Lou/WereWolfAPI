package fr.ph1lou.werewolfapi.events.game.vote;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class NewVoteResultEvent extends Event implements Cancellable {

    private IPlayerWW villagerWW;
    private IPlayerWW werewolfWW;
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean cancel=false;

    public NewVoteResultEvent(IPlayerWW villagerWW, IPlayerWW werewolfWW){
        this.villagerWW = villagerWW;
        this.werewolfWW = werewolfWW;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }


    public void setPlayerVotedByVillagerWW(IPlayerWW playerWW){
        this.villagerWW = playerWW;
    }

    public void setPlayerVotedByWerewolfWW(IPlayerWW playerWW){
        this.werewolfWW = playerWW;
    }

    public IPlayerWW getPlayerVotedByVillagerWW(){
        return this.villagerWW;
    }

    public IPlayerWW getPlayerVotedByWerewolfWW(){
        return this.werewolfWW;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel=cancel;
    }
}
