package fr.ph1lou.werewolfapi.events.roles.bonesetter;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
@StatisticsEvent(key = "werewolf.bonesetter_choose")
public class BonesetterChooseEvent extends SelectionEvent {
    public BonesetterChooseEvent(IPlayerWW playerWW, IPlayerWW targetWW) {
        super(playerWW, targetWW);
    }
}
