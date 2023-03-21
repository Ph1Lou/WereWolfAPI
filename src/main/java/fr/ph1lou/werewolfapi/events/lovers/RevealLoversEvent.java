package fr.ph1lou.werewolfapi.events.lovers;

import fr.ph1lou.werewolfapi.lovers.ILover;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RevealLoversEvent extends Event {


    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final List<ILover> lovers;

    public RevealLoversEvent(List<ILover> lovers) {
        this.lovers = lovers;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public List<? extends ILover> getLovers() {
        return lovers;
    }
}

