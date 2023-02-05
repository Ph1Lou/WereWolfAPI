package fr.ph1lou.werewolfapi.events.roles.croupier;

import fr.ph1lou.werewolfapi.annotations.TellableStoryEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.croupier_choose")
public class CroupierChooseEventEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public CroupierChooseEventEvent(IPlayerWW playerWW, IPlayerWW targetUUID) {
        super(playerWW, targetUUID);

    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

}

