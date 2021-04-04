package io.github.ph1lou.werewolfapi.events.lovers;

import io.github.ph1lou.werewolfapi.ILover;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RevealLoversEvent extends Event {


    private final List<ILover> lovers;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public RevealLoversEvent(List<ILover> lovers) {
        this.lovers = lovers;
    }


    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public List<? extends ILover> getLovers() {
        return lovers;
    }
}

