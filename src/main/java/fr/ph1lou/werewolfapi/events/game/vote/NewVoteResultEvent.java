package fr.ph1lou.werewolfapi.events.game.vote;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsPlayer;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsTarget;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StatisticsEvent(key = "werewolf.new_vote")
public class NewVoteResultEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private @Nullable IPlayerWW villagerWW;
    private @Nullable IPlayerWW werewolfWW;
    private boolean cancel = false;

    public NewVoteResultEvent(@Nullable IPlayerWW villagerWW, @Nullable IPlayerWW werewolfWW) {
        this.villagerWW = villagerWW;
        this.werewolfWW = werewolfWW;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    @StatisticsPlayer
    public @Nullable IPlayerWW getPlayerVotedByVillagerWW() {
        return this.villagerWW;
    }

    public void setPlayerVotedByVillagerWW(IPlayerWW playerWW) {
        this.villagerWW = playerWW;
    }

    @StatisticsTarget
    public @Nullable IPlayerWW getPlayerVotedByWerewolfWW() {
        return this.werewolfWW;
    }

    public void setPlayerVotedByWerewolfWW(IPlayerWW playerWW) {
        this.werewolfWW = playerWW;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }
}
