package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.rolesattributs.LoverAPI;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RevealLoversEvent extends Event {


    private final List<LoverAPI> loverAPIS;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public RevealLoversEvent(List<LoverAPI> loverAPIS) {
        this.loverAPIS = loverAPIS;
    }


    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public List<? extends LoverAPI> getLovers() {
        return loverAPIS;
    }
}

