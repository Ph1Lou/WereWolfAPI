package fr.ph1lou.werewolfapi.role.interfaces;

import fr.ph1lou.werewolfapi.enums.Aura;
import fr.ph1lou.werewolfapi.player.interfaces.IAuraModifier;

import java.util.List;
import java.util.Optional;

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
