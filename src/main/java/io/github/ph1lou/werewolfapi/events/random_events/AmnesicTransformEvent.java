package io.github.ph1lou.werewolfapi.events.random_events;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import io.github.ph1lou.werewolfapi.events.roles.SelectionEvent;

public class AmnesicTransformEvent extends SelectionEvent {

    public AmnesicTransformEvent(IPlayerWW playerWW, IPlayerWW targetWW) {
        super(playerWW, targetWW);
    }
}
