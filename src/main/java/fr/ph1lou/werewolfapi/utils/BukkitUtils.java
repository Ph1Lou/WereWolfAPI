package fr.ph1lou.werewolfapi.utils;

import fr.ph1lou.werewolfapi.GetWereWolfAPI;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class BukkitUtils {


    /**
     * Schedule Sync delayed Task
     * @param runnable the task
     * @param delay the delay
     * @return the task id
     */
    public static int scheduleSyncDelayedTask(@NotNull Runnable runnable, long delay){

        GetWereWolfAPI api = Bukkit.getServer().getServicesManager().load(GetWereWolfAPI.class);
        if(api==null){
            throw new RuntimeException("WereWolfPlugin not loaded");
        }
        return Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) api,runnable,delay);
    }

    /**
     * Schedule Sync delayed Task (1 tick)
     * @param runnable the task
     * @return task id
     */
    public static int scheduleSyncDelayedTask(@NotNull Runnable runnable){
        return scheduleSyncDelayedTask(runnable,1);
    }

    /**
     * Register Bukkit Listener
     * @param listener the listener
     */
    public static void registerListener(@NotNull Listener listener){
        GetWereWolfAPI api = Bukkit.getServer().getServicesManager().load(GetWereWolfAPI.class);
        if(api==null){
            throw new RuntimeException("WereWolfPlugin not loaded");
        }
        Bukkit.getPluginManager().registerEvents(listener, (Plugin) api);
    }


    /**
     * Schedule Sync Repeating Task
     * @param runnable the task
     * @param delay the initial delay
     * @param period the period
     * @return the task id
     */
    public static int scheduleSyncRepeatingTask(@NotNull Runnable runnable, long delay, long period){
        GetWereWolfAPI api = Bukkit.getServer().getServicesManager().load(GetWereWolfAPI.class);
        if(api==null){
            throw new RuntimeException("WereWolfPlugin not loaded");
        }
        return Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin) api,runnable,delay,period);
    }

    public static int loadServerVersion(){
        String versionString = Bukkit.getBukkitVersion();
        int version = 0;

        for (int i = 8; i <= 100; i ++){
            if (versionString.startsWith("1." + i)){
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
