package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.PlayerWW;
import io.github.ph1lou.werewolfapi.enumlg.AngelForm;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class AngelChoiceEvent extends Event {

    private final PlayerWW playerWW;
    private final AngelForm choice;

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public AngelChoiceEvent(PlayerWW playerWW, AngelForm choice){
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

    public PlayerWW getPlayerWW() {
        return playerWW;
    }

    public AngelForm getChoice() {
        return choice;
    }
}

