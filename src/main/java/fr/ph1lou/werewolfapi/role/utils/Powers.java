package fr.ph1lou.werewolfapi.role.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Registre léger des pouvoirs nommés d'un rôle, associant à chaque clé un
 * nombre d'utilisations restantes. Destiné à être détenu par un rôle
 * implémentant {@link fr.ph1lou.werewolfapi.role.interfaces.IPowers} (auquel
 * il délègue ses méthodes par défaut).
 *
 * <p>Un pouvoir « one-shot » s'enregistre via {@link #add(String)} (1 utilisation) ;
 * un pouvoir multi-usage via {@link #add(String, int)}.</p>
 */
public class Powers {

    private final Map<String, Integer> uses = new HashMap<>();

    /** Enregistre un pouvoir one-shot (1 utilisation). Chainable. */
    public Powers add(String key) {
        return add(key, 1);
    }

    /** Enregistre un pouvoir avec n utilisations (n négatif ramené à 0). Chainable. */
    public Powers add(String key, int n) {
        uses.put(key, Math.max(0, n));
        return this;
    }

    /** true s'il reste au moins une utilisation du pouvoir. */
    public boolean has(String key) {
        return uses.getOrDefault(key, 0) > 0;
    }

    /** Consomme une utilisation du pouvoir (décrémente, floor 0 ; no-op si absent). */
    public void use(String key) {
        uses.computeIfPresent(key, (k, v) -> Math.max(0, v - 1));
    }

    /** Nombre d'utilisations restantes (0 si pouvoir inconnu). */
    public int getUses(String key) {
        return uses.getOrDefault(key, 0);
    }

    /** Réinitialise / ajuste le nombre d'utilisations d'un pouvoir. */
    public void setUses(String key, int n) {
        uses.put(key, Math.max(0, n));
    }

    /** Toutes les clés de pouvoirs enregistrés (vue non modifiable, pour itération / affichage). */
    public Set<String> keys() {
        return Collections.unmodifiableSet(uses.keySet());
    }
}
