package fr.ph1lou.werewolfapi.events.roles.analyst;

import fr.ph1lou.werewolfapi.annotations.TellableStoryEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsExtraInfo;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.stream.Collectors;


@StatisticsEvent(key = "werewolf.analyst_analyst")
@TellableStoryEvent
public class AnalystExtraDetailsEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private final Set<PotionEffectType> potions;

    public AnalystExtraDetailsEvent(IPlayerWW playerWW, IPlayerWW targetUUID, Set<PotionEffectType> potions) {
        super(playerWW, targetUUID);
        this.potions = potions;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public Set<PotionEffectType> getPotions() {
        return this.potions;
    }

    @StatisticsExtraInfo
    public String getExtraInfo() {
        return getPotions()
                .stream()
                .map(PotionEffectType::getName)
                .collect(Collectors.joining(", "));
    }

}

