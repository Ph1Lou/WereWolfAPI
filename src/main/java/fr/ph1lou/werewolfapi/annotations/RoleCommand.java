package fr.ph1lou.werewolfapi.annotations;

import fr.ph1lou.werewolfapi.enums.StateGame;
import fr.ph1lou.werewolfapi.enums.StatePlayer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RoleCommand {

    String key();

    String[] roleKeys();

    StatePlayer[] statesPlayer() default StatePlayer.ALIVE;

    StateGame[] statesGame() default StateGame.GAME;

    int[] argNumbers();

    boolean autoCompletion() default true;

    boolean requiredPower() default false;

    boolean requiredAbilityEnabled() default true;

    /** Si {@code >= 0}, requiert que le rôle ({@code ILimitedUse}) n'ait pas atteint ce nombre d'utilisations. */
    int requiredLimitedUse() default -1;

    /** Descripteurs des paramètres d'entrée (résolus/validés par le dispatcher). */
    Params args() default @Params;
}