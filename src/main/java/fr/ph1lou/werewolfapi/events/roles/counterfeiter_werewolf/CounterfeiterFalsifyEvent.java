package fr.ph1lou.werewolfapi.events.roles.counterfeiter_werewolf;

import fr.ph1lou.werewolfapi.annotations.TellableStoryEvent;
import fr.ph1lou.werewolfapi.basekeys.RoleBase;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsExtraInfo;
import fr.ph1lou.werewolfapi.enums.Aura;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.counterfeiter_falsify_event")
@TellableStoryEvent(roleKey = RoleBase.COUNTERFEITER_WEREWOLF, key = "werewolf.tellable_story.counterfeiter_falsify")
public class CounterfeiterFalsifyEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private final String facadeRole;
    private final String facadeCamp;
    private final Aura facadeAura;

    public CounterfeiterFalsifyEvent(IPlayerWW playerWW, IPlayerWW targetWW,
                                     String facadeRole, String facadeCamp, Aura facadeAura) {
        super(playerWW, targetWW);
        this.facadeRole = facadeRole;
        this.facadeCamp = facadeCamp;
        this.facadeAura = facadeAura;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    @StatisticsExtraInfo
    public String getFacadeRole() {
        return facadeRole;
    }

    public String getFacadeCamp() {
        return facadeCamp;
    }

    public Aura getFacadeAura() {
        return facadeAura;
    }
}
