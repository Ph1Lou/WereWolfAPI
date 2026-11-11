package fr.ph1lou.werewolfapi.utils;

import fr.ph1lou.werewolfapi.GetWereWolfAPI;
import fr.ph1lou.werewolfapi.annotations.RequireAbility;
import fr.ph1lou.werewolfapi.annotations.RequireAlive;
import fr.ph1lou.werewolfapi.annotations.RequirePower;
import fr.ph1lou.werewolfapi.game.WereWolfAPI;
import fr.ph1lou.werewolfapi.role.interfaces.IPower;
import fr.ph1lou.werewolfapi.role.interfaces.IRole;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventException;
import org.bukkit.event.Listener;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BukkitUtils {


    /**
     * Schedule Sync delayed Task
     *
     * @param runnable the task
     * @param delay    the delay
     * @return the task id
     */
    public static int scheduleSyncDelayedTask(WereWolfAPI game, @NotNull Runnable runnable, long delay) {

        GetWereWolfAPI api = Bukkit.getServer().getServicesManager().load(GetWereWolfAPI.class);
        if (api == null) {
            throw new RuntimeException("WereWolfPlugin not loaded");
        }

        int idSchedule = Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) api, runnable, delay);

        game.addScheduleId(idSchedule);
        return idSchedule;
    }

    /**
     * Schedule Sync delayed Task (1 tick)
     *
     * @param runnable the task
     * @return task id
     */
    public static int scheduleSyncDelayedTask(WereWolfAPI game, @NotNull Runnable runnable) {
        return scheduleSyncDelayedTask(game, runnable, 1);
    }

    /**
     * Register Bukkit Listener
     *
     * <p>This is the single registration chokepoint for the plugin (roles,
     * configs, scenarios, timers, random events, lovers and core listeners all
     * go through here). When a listener implements {@link IRole} or
     * {@link IPower} and at least one of its {@code @EventHandler} methods is
     * annotated with {@link RequireAbility}, {@link RequireAlive} or
     * {@link RequirePower}, every {@code @EventHandler} of that listener is
     * registered through a dedicated {@link GuardedEventExecutor} that applies
     * the guards before invoking the method. Otherwise the standard Bukkit
     * {@code registerEvents} path is used, so there is zero behavior change for
     * listeners that do not use the guard annotations.
     *
     * @param listener the listener
     */
    public static void registerListener(@NotNull Listener listener) {
        GetWereWolfAPI api = Bukkit.getServer().getServicesManager().load(GetWereWolfAPI.class);
        if (api == null) {
            throw new RuntimeException("WereWolfPlugin not loaded");
        }
        Plugin plugin = (Plugin) api;

        boolean isRole = listener instanceof IRole;
        boolean isPower = listener instanceof IPower;
        Method[] methods = listener.getClass().getMethods();
        boolean hasGuards = false;

        for (Method method : methods) {
            if (!method.isAnnotationPresent(EventHandler.class) || method.isBridge()) {
                continue;
            }
            boolean requireAbility = method.isAnnotationPresent(RequireAbility.class);
            boolean requireAlive = method.isAnnotationPresent(RequireAlive.class);
            boolean requirePower = method.isAnnotationPresent(RequirePower.class);
            if (requireAbility || requireAlive || requirePower) {
                hasGuards = true;
                if ((requireAbility || requireAlive) && !isRole) {
                    Bukkit.getLogger().warning("[WereWolfPlugin] @RequireAbility/@RequireAlive "
                            + "used on a non-role listener "
                            + listener.getClass().getName() + "#" + method.getName()
                            + "; guard annotations are ignored.");
                }
                if (requirePower && !isPower) {
                    Bukkit.getLogger().warning("[WereWolfPlugin] @RequirePower "
                            + "used on a non-IPower listener "
                            + listener.getClass().getName() + "#" + method.getName()
                            + "; guard annotation is ignored.");
                }
            }
        }

        if (!hasGuards || (!isRole && !isPower)) {
            Bukkit.getPluginManager().registerEvents(listener, plugin);
            return;
        }

        for (Method method : methods) {
            if (!method.isAnnotationPresent(EventHandler.class) || method.isBridge()) {
                continue;
            }
            Class<?>[] params = method.getParameterTypes();
            if (params.length != 1 || !Event.class.isAssignableFrom(params[0])) {
                continue;
            }

            EventHandler handler = method.getAnnotation(EventHandler.class);
            @SuppressWarnings("unchecked")
            Class<? extends Event> eventClass = (Class<? extends Event>) params[0];

            EventExecutor executor;
            if (method.isAnnotationPresent(RequireAbility.class)
                    || method.isAnnotationPresent(RequireAlive.class)
                    || method.isAnnotationPresent(RequirePower.class)) {
                executor = new GuardedEventExecutor(method);
            } else {
                final Method m = method;
                executor = (listenerRef, event) -> {
                    try {
                        m.invoke(listenerRef, event);
                    } catch (InvocationTargetException e) {
                        throw new EventException(e.getCause());
                    } catch (IllegalAccessException e) {
                        throw new EventException(e);
                    }
                };
            }

            Bukkit.getPluginManager().registerEvent(
                    eventClass, listener, handler.priority(), executor, plugin, handler.ignoreCancelled());
        }
    }


    /**
     * Schedule Sync Repeating Task
     *
     * @param runnable the task
     * @param delay    the initial delay
     * @param period   the period
     * @return the task id
     */
    public static int scheduleSyncRepeatingTask(WereWolfAPI game, @NotNull Runnable runnable, long delay, long period) {
        GetWereWolfAPI api = Bukkit.getServer().getServicesManager().load(GetWereWolfAPI.class);
        if (api == null) {
            throw new RuntimeException("WereWolfPlugin not loaded");
        }
        int schedulerId = Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin) api, runnable, delay, period);
        game.addScheduleId(schedulerId);
        return schedulerId;
    }

    public static int loadServerVersion() {
        String versionString = Bukkit.getBukkitVersion();
        int version = 0;

        for (int i = 8; i <= 100; i++) {
            if (versionString.startsWith("1." + i)) {
                version = i;
            }
        }

        if (version == 0) {
            version = 8;
            Bukkit.getLogger().warning("[WereWolfPlugin] Failed to detect server version! " + versionString + "?");
        }
        return version;
    }

}
