package io.github.ph1lou.werewolfapi.rolesattributs;

import io.github.ph1lou.werewolfapi.IAuraModifier;
import io.github.ph1lou.werewolfapi.enums.Aura;

import java.util.List;

/**
 * Aura methods for oracle
 */
public interface IAura {

    Aura getAura();

    Aura getDefaultAura();

    void addAuraModifier(IAuraModifier auraModifier);

    void removeAuraModifier(IAuraModifier auraModifier);

    void removeAuraModifier(String modifierName);

    void removeTemporaryAuras();

    List<IAuraModifier> getAuraModifiers();
}
