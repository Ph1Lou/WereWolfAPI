package fr.ph1lou.werewolfapi.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Guards a Bukkit {@link org.bukkit.event.EventHandler} method so it is only
 * invoked when the owning role still has its power available
 * ({@code hasPower() == true}, see {@link fr.ph1lou.werewolfapi.role.interfaces.IPower}).
 *
 * <p>This replaces the recurring boilerplate found in power-based roles:
 * <pre>{@code
 * if (!power) return;        // field form
 * if (!hasPower()) return;   // interface form
 * }</pre>
 *
 * <p>The guard is applied by {@code BukkitUtils.registerListener} through a
 * dedicated {@link org.bukkit.plugin.EventExecutor}; it only has an effect on
 * listeners that implement
 * {@link fr.ph1lou.werewolfapi.role.interfaces.IPower}. Using it on any other
 * listener has no effect and logs a warning at registration time.
 *
 * <p>Do <b>not</b> use this for:
 * <ul>
 *   <li>roles that model {@code power} as an <em>integer counter</em>
 *       (e.g. {@code if (power >= 3) ...}) &mdash; those are not boolean flags;</li>
 *   <li>positive logic such as {@code if (power) ...} or {@code if (power) return;}
 *       &mdash; those are role-specific behaviour, not a "require power" guard.</li>
 * </ul>
 * Only the {@code if (!power) return;} / {@code if (!hasPower()) return;} early
 * return (possibly combined with {@link RequireAbility} /
 * {@link RequireAlive}) should be migrated.
 *
 * <p>Runs <b>after</b> Bukkit's {@code ignoreCancelled} filter and composes
 * with the other guard annotations.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequirePower {
}
