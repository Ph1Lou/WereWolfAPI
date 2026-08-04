package fr.ph1lou.werewolfapi.role.interfaces;

import fr.ph1lou.werewolfapi.role.utils.Powers;

/**
 * Mixin pour les rôles disposant de plusieurs pouvoirs nommés indépendants,
 * chacun doté d'un nombre d'utilisations. Contrairement à {@link IPower}
 * (un seul booléen) ou {@link ILimitedUse} (un seul compteur), {@code IPowers}
 * gère N pouvoirs distincts.
 *
 * <p>Opt-in minimal : le rôle implémente uniquement {@link #getPowers()} en
 * retournant un champ {@code private final Powers} ; toutes les autres méthodes
 * sont fournies par défaut et délèguent à ce registre.</p>
 *
 * <p><b>Convention de clé</b> : la clé d'un pouvoir DOIT être une clé de traduction
 * (préfixée {@code werewolf.roles.<role>.powers.<id>}, en minuscules) dont la valeur
 * JSON est le nom affichable du pouvoir. Cette même clé sert d'identifiant interne
 * {@code (add/has/use)} ET de nom traduit dans la commande admin role
 * ({@code game.translate(key)}). Définir une constante {@code public static final
 * String} par pouvoir sur le rôle et la référencer partout (constructeur, annotation
 * {@code @RoleCommand(requiredPowerKey = ...)}, consommation) pour éviter toute
 * désynchronisation.</p>
 *
 * <pre>{@code
 * public class MonRole extends RoleImpl implements IPowers {
 *     public static final String POWER_A = "werewolf.roles.monrole.powers.a";
 *     private final Powers powers = new Powers();
 *     public MonRole(WereWolfAPI api, IPlayerWW p) {
 *         super(api, p);
 *         powers.add(POWER_A).add("werewolf.roles.monrole.powers.b", 3); // A one-shot, B x3
 *     }
 *     @Override public Powers getPowers() { return powers; }
 * }
 * }</pre>
 *
 * <p>Côté commande : {@code @RoleCommand(requiredPowerKey = MonRole.POWER_A)} déclenche la
 * vérification automatique par le dispatcher ; la commande consomme ensuite via
 * {@link #usePower(String)}.</p>
 *
 * <p>Aucun conflit avec {@code IPower} : {@link #hasPower(String)} se distingue de
 * {@code IPower.hasPower()} par son argument.</p>
 */
public interface IPowers {

    /** Le registre des pouvoirs du rôle (retourner un champ final). */
    Powers getPowers();

    /** true s'il reste au moins une utilisation du pouvoir nommé. */
    default boolean hasPower(String key) {
        return getPowers().has(key);
    }

    /** Consomme une utilisation du pouvoir nommé. */
    default void usePower(String key) {
        getPowers().use(key);
    }

    /** Nombre d'utilisations restantes du pouvoir nommé (0 si inconnu). */
    default int getPowerUses(String key) {
        return getPowers().getUses(key);
    }

    /** Enregistre un pouvoir one-shot. */
    default void addPower(String key) {
        getPowers().add(key);
    }

    /** Enregistre un pouvoir avec un nombre d'utilisations. */
    default void addPower(String key, int uses) {
        getPowers().add(key, uses);
    }

    /** Réinitialise / ajuste les utilisations d'un pouvoir. */
    default void setPowerUses(String key, int uses) {
        getPowers().setUses(key, uses);
    }
}
