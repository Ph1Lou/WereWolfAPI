package io.github.ph1lou.werewolfapi;

import io.github.ph1lou.werewolfapi.enums.Aura;

public interface IAuraModifier extends Comparable<IAuraModifier> {

    Aura getAura();

    int getPriority();

    String getName();
}
