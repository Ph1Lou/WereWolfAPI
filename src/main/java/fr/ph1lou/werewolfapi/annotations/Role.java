package fr.ph1lou.werewolfapi.annotations;

import fr.ph1lou.werewolfapi.enums.Aura;
import fr.ph1lou.werewolfapi.enums.Category;
import fr.ph1lou.werewolfapi.enums.RoleAttribute;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Role {

    String key();

    String[] loreKey() default {};

    Category category();

    RoleAttribute attribute();

    float weight() default 1;

    boolean requireDouble() default false;

    String[] requireRoles() default {};

    String[] incompatibleRoles() default {};

    IntValue[] configValues() default {};

    Configuration[] configurations() default {};

    Timer[] timers() default {};

    String auraDescriptionSpecialUseCase() default "";

    Aura defaultAura() default Aura.LIGHT;

    int powerModifier() default 0;

    int sharpnessIronModifier() default 0;

    int sharpnessDiamondModifier() default 0;

    int protectionIronModifier() default 0;

    int protectionDiamondModifier() default 0;
}