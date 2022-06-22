package com.carpour.nameverif.api;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class GeyserUtil {

    private GeyserUtil() {}

    public static Plugin getGeyserAPI() {

        return Bukkit.getPluginManager().getPlugin("geyser-spigot");
    }
}
