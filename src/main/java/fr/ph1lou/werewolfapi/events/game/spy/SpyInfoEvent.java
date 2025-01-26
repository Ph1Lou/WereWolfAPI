package fr.ph1lou.werewolfapi.events.game.spy;

import fr.ph1lou.werewolfapi.annotations.TellableStoryEvent;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@TellableStoryEvent
public class SpyInfoEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final String event;

    public SpyInfoEvent(IPlayerWW playerWW, IPlayerWW target, String event) {
        super(playerWW, target);
        this.event = event;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public String getEvent() {
        return event;
    }


}