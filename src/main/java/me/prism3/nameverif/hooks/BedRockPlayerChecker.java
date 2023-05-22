package me.prism3.nameverif.hooks;

import me.prism3.nameverif.utils.Log;
import org.bukkit.Bukkit;


/**
 * Utility class for checking Geyser and Floodgate plugin hook.
 */
public class BedRockPlayerChecker {

    private static final String FLOODGATE_API_CLASS = "org.geysermc.floodgate.api.FloodgateApi";
    private static final String GEYSER_PLUGIN_NAME = "geyser-spigot";

    private BedRockPlayerChecker() {}

    /**
     * Checks if the FloodgateApi class is present.
     *
     * @return true if the FloodgateApi class is found, false otherwise.
     */
    private static boolean hasClass() {
        try {
            Class.forName(FLOODGATE_API_CLASS);
            return true;
        } catch (final ClassNotFoundException ignored) {
            return false;
        }
    }

    /**
     * Checks if the Geyser and Floodgate plugins are detected.
     *
     * @return true if both Geyser and Floodgate plugins are present, false otherwise.
     */
    public static boolean isGeyserFloodGateHookEnabled() {
        if (hasClass() && Bukkit.getPluginManager().getPlugin(GEYSER_PLUGIN_NAME) != null) {
            Log.info("Geyser and FloodGate plugins detected!");
            return true;
        }
        return false;
    }
}
