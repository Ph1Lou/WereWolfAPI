package fr.ph1lou.werewolfapi.annotations;

import fr.ph1lou.werewolfapi.enums.StatePlayer;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Paramètre de commande de type joueur cible, résolu en {@code IPlayerWW}.
 * Membre de {@link Params#players()}.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface PlayerArg {

    /**
     * Position dans le tableau {@code args} reçu par {@code execute} (post-sous-commande) :
     * {@code 0} = premier vrai paramètre.
     */
    int index();

    /**
     * Résout l'argument comme une {@link java.util.UUID} (textuelle) via
     * {@code game.getPlayerWW(UUID.fromString(raw))} au lieu d'un nom via
     * {@code Bukkit.getPlayer}. Pour les commandes manipulant des UUID (ex. cibles
     * mortes / hors-ligne). L'autocomplétion est désactivée pour ce mode (un UUID ne
     * se tape pas) — poser aussi {@code autoCompletion = false} sur la commande.
     */
    boolean byUuid() default false;

    /** États autorisés du joueur cible (vide = aucun état requis). */
    StatePlayer[] states() default {};

    /** Interdit au joueur de se cibler lui-même (→ {@code werewolf.check.not_yourself}). */
    boolean excludeSelf() default false;

    /** Surcharge du message d'échec d'état (vide = {@code werewolf.check.state_player}). */
    String stateMessageKey() default "";

    /**
     * Rejette si la cible est déjà dans les joueurs affectés du rôle exécuteur
     * ({@code IAffectedPlayers}) → {@code alreadyAffectedMessageKey} ou
     * {@code werewolf.check.already_get_power}. Sans effet si l'exécuteur n'a pas de rôle
     * ou si celui-ci n'implémente pas {@code IAffectedPlayers}.
     */
    boolean rejectIfAlreadyAffected() default false;

    /** Surcharge du message « déjà affecté » (vide = {@code werewolf.check.already_get_power}). */
    String alreadyAffectedMessageKey() default "";

    /** Distance maximale (exécuteur ↔ cible) ; clé d'une {@code IntValue}. Vide = pas de vérification. */
    String maxDistanceKey() default "";

    /** Surcharge du message d'échec de distance (vide = {@code werewolf.check.distance}). */
    String maxDistanceMessageKey() default "";

    /** {@code false} = paramètre optionnel. */
    boolean required() default true;
}
