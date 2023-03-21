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
}