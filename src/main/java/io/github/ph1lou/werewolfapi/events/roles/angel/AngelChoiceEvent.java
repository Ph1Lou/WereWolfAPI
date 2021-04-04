package io.github.ph1lou.werewolfapi.events.roles.angel;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import io.github.ph1lou.werewolfapi.enums.AngelForm;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class AngelChoiceEvent extends Event {

    private final IPlayerWW playerWW;
    private final AngelForm choice;

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public AngelChoiceEvent(IPlayerWW playerWW, AngelForm choice){
        this.playerWW = playerWW;
        this.choice = choice;
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
        return this.playerWW;
    }

    public AngelForm getChoice() {
        return choice;
    }
}

