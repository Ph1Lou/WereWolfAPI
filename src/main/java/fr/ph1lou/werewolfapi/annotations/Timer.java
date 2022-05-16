package fr.ph1lou.werewolfapi.annotations;

import org.bukkit.event.Event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Timer {
    String key();
    int defaultValue();
    int meetUpValue();
    String[] loreKey() default {};
    boolean decrementAfterRole() default false;
    String decrementAfterTimer() default ""
    boolean decrement() default false;
    int step() default 5;
    Class<? extends Event> onZero() default Event.class;
}