package fr.ph1lou.werewolfapi.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Guards a Bukkit {@link org.bukkit.event.EventHandler} method so it is only
 * invoked when the owning {@link fr.ph1lou.werewolfapi.role.interfaces.IRole}
 * has its ability enabled ({@code isAbilityEnabled() == true}).
 *
 * <p>This replaces the recurring boilerplate:
 * <pre>{@code
 * if (!isAbilityEnabled()) return;
 * }</pre>
 *
 * <p>The guard is applied by {@code BukkitUtils.registerListener} through a
 * dedicated {@link org.bukkit.plugin.EventExecutor}; it only has an effect on
 * listeners that implement {@link fr.ph1lou.werewolfapi.role.interfaces.IRole}
 * (typically role classes extending {@code RoleImpl}). Using it on any other
 * listener has no effect and logs a warning at registration time.
 *
 * <p>Runs <b>after</b> Bukkit's {@code ignoreCancelled} filter, so it composes
 * naturally with {@code @EventHandler(ignoreCancelled = true)}.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequireAbility {
}
