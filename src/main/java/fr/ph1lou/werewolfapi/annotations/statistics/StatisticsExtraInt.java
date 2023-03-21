package fr.ph1lou.werewolfapi.annotations.statistics;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * Statistics usage
 * Annotation for method who return int, One per Class !!!
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface StatisticsExtraInt {
}
