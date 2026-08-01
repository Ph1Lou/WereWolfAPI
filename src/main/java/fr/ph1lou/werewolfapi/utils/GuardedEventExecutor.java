package fr.ph1lou.werewolfapi.utils;

import fr.ph1lou.werewolfapi.annotations.RequireAbility;
import fr.ph1lou.werewolfapi.annotations.RequireAlive;
import fr.ph1lou.werewolfapi.annotations.RequirePower;
import fr.ph1lou.werewolfapi.enums.StatePlayer;
import fr.ph1lou.werewolfapi.role.interfaces.IPower;
import fr.ph1lou.werewolfapi.role.interfaces.IRole;
import org.bukkit.event.Event;
import org.bukkit.event.EventException;
import org.bukkit.event.Listener;
import org.bukkit.plugin.EventExecutor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * {@link EventExecutor} that applies the {@link RequireAbility} /
 * {@link RequireAlive} / {@link RequirePower} guards before delegating to the
 * wrapped {@code @EventHandler} method.
 *
 * <p>Each guard only applies when the listener implements the matching
 * interface ({@link IRole} for ability/alive, {@link IPower} for power). The
 * owning {@link BukkitUtils#registerListener} makes sure this executor is only
 * used for guarded methods on listeners that support at least one guard, so the
 * casts are always valid in practice; the {@code instanceof} checks are kept as
 * defensive no-op fallbacks.
 *
 * <p>Execution order for a guarded handler is therefore:
 * <ol>
 *   <li>Bukkit's {@code ignoreCancelled} filter (handled by {@code RegisteredListener})</li>
 *   <li>{@link RequireAbility} check ({@code isAbilityEnabled()})</li>
 *   <li>{@link RequireAlive} check ({@code getPlayerWW().isState(StatePlayer.ALIVE)})</li>
 *   <li>{@link RequirePower} check ({@code hasPower()})</li>
 *   <li>the handler method body</li>
 * </ol>
 * This exactly mirrors the manual early-return guards it replaces.
 */
public class GuardedEventExecutor implements EventExecutor {

    private final Method method;
    private final boolean requireAbility;
    private final boolean requireAlive;
    private final boolean requirePower;

    public GuardedEventExecutor(Method method) {
        this.method = method;
        this.method.setAccessible(true);
        this.requireAbility = method.isAnnotationPresent(RequireAbility.class);
        this.requireAlive = method.isAnnotationPresent(RequireAlive.class);
        this.requirePower = method.isAnnotationPresent(RequirePower.class);
    }

    @Override
    public void execute(Listener listener, Event event) throws EventException {
        if (this.requireAbility && listener instanceof IRole
                && !((IRole) listener).isAbilityEnabled()) {
            return;
        }
        if (this.requireAlive && listener instanceof IRole
                && !((IRole) listener).getPlayerWW().isState(StatePlayer.ALIVE)) {
            return;
        }
        if (this.requirePower && listener instanceof IPower
                && !((IPower) listener).hasPower()) {
            return;
        }
        try {
            this.method.invoke(listener, event);
        } catch (InvocationTargetException e) {
            throw new EventException(e.getCause());
        } catch (IllegalAccessException e) {
            throw new EventException(e);
        }
    }
}
