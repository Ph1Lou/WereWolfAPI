package fr.ph1lou.werewolfapi.events.roles.angel;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsExtraInfo;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsPlayer;
import fr.ph1lou.werewolfapi.enums.AngelForm;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.angel_choice")
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

    @StatisticsPlayer
    public IPlayerWW getPlayerWW() {
        return this.playerWW;
    }

    public AngelForm getChoice() {
        return choice;
    }

    @StatisticsExtraInfo
    public String getExtraInfo(){
        return choice.toString();
    }
}

