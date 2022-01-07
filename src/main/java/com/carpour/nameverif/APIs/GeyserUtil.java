package com.carpour.nameverif.APIs;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class GeyserUtil {

    public static Plugin getGeyserAPI(){

        return Bukkit.getPluginManager().getPlugin("geyser-spigot");
    }
}
