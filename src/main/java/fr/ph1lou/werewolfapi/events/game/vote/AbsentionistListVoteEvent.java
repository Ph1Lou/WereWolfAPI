package fr.ph1lou.werewolfapi.events.game.vote;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AbsentionistListVoteEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final List<IPlayerWW> abstentionistList;


    public AbsentionistListVoteEvent(List<IPlayerWW> abstentionistList) {
        this.abstentionistList = abstentionistList;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public List<IPlayerWW> getAbstentionistList() {
        return abstentionistList;
    }

}
