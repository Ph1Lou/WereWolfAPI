package fr.ph1lou.werewolfapi.events.roles.librarian;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsExtraInfo;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.give_back_book")
public class LibrarianGiveBackEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private String info;

    public LibrarianGiveBackEvent(IPlayerWW playerWW, IPlayerWW targetWW, String info) {
        super(playerWW,targetWW);
        this.info=info;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @StatisticsExtraInfo
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}