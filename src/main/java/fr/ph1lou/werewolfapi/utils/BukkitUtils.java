package fr.ph1lou.werewolfapi.utils;

import fr.ph1lou.werewolfapi.GetWereWolfAPI;
import fr.ph1lou.werewolfapi.enums.StateGame;
import fr.ph1lou.werewolfapi.game.WereWolfAPI;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.atomic.AtomicInteger;

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
        return Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) api, () -> {
            if (!game.isState(StateGame.END)) {
                runnable.run();
            }
        }, delay);
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
     * @param listener the listener
     */
    public static void registerListener(@NotNull Listener listener) {
        GetWereWolfAPI api = Bukkit.getServer().getServicesManager().load(GetWereWolfAPI.class);
        if (api == null) {
            throw new RuntimeException("WereWolfPlugin not loaded");
        }
        Bukkit.getPluginManager().registerEvents(listener, (Plugin) api);
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
        AtomicInteger schedulerId = new AtomicInteger();
        schedulerId.set(Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin) api, () -> {
            if (!game.isState(StateGame.END)) {
                runnable.run();
            } else {
                Bukkit.getScheduler().cancelTask(schedulerId.get());
            }
        }, delay, period));
        return schedulerId.get();
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
