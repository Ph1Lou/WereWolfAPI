package fr.ph1lou.werewolfapi.annotations;

import fr.ph1lou.werewolfapi.enums.UniversalMaterial;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface IntValue {
    String key();
    int defaultValue();
    int meetUpValue();
    double step();
    UniversalMaterial item();
}