package fr.ph1lou.werewolfapi.role.interfaces;

import fr.ph1lou.werewolfapi.player.interfaces.IAuraModifier;
import fr.ph1lou.werewolfapi.enums.Aura;

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
