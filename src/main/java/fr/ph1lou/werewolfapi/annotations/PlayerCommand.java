package fr.ph1lou.werewolfapi.annotations;

import fr.ph1lou.werewolfapi.enums.StateGame;
import fr.ph1lou.werewolfapi.enums.StatePlayer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PlayerCommand {

    String key();
    String descriptionKey();
    StatePlayer[] statesPlayer() default {};
    StateGame[] statesGame() default {};
    int[] argNumbers() default {};
    boolean autoCompletion() default true;
}