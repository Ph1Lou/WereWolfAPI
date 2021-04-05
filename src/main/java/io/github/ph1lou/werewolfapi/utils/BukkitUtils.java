package io.github.ph1lou.werewolfapi.utils;

import io.github.ph1lou.werewolfapi.GetWereWolfAPI;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class BukkitUtils {


    public static int scheduleSyncDelayedTask(@NotNull Runnable runnable, long delay){

        GetWereWolfAPI api = Bukkit.getServer().getServicesManager().load(GetWereWolfAPI.class);
        if(api==null){
            throw new RuntimeException("WereWolfPlugin not loaded");
        }
        return Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) api,runnable,delay);
    }

    public static int scheduleSyncDelayedTask(@NotNull Runnable runnable){
        return scheduleSyncDelayedTask(runnable,1);
    }

    public static void registerEvents(@NotNull Listener listener){
        GetWereWolfAPI api = Bukkit.getServer().getServicesManager().load(GetWereWolfAPI.class);
        if(api==null){
            throw new RuntimeException("WereWolfPlugin not loaded");
        }
        Bukkit.getPluginManager().registerEvents(listener, (Plugin) api);
    }

}
