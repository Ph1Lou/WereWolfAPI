package fr.ph1lou.werewolfapi.events.roles.falsifier_werewolf;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsExtraInfo;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsPlayer;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.new_display_role")
public class NewDisplayRole extends Event implements Cancellable {

    private final IPlayerWW playerWW;
    private final String newDisplayRole;
    private final String newDisplayCamp;
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean cancel=false;

    public NewDisplayRole(IPlayerWW playerWW, String newDisplayRole1, String newDisplayCamp){
        this.playerWW = playerWW;
        this.newDisplayRole = newDisplayRole1;

        this.newDisplayCamp = newDisplayCamp;
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


    public String getNewDisplayCamp() {
        return newDisplayCamp;
    }

    @StatisticsExtraInfo
    public String getNewDisplayRole() {
        return newDisplayRole;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel=cancel;
    }
}

