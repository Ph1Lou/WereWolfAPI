package fr.ph1lou.werewolfapi.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Need to have one @StatisticsPlayer
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TellableStoryEvent {
}
