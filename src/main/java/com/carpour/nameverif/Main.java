package com.carpour.nameverif;

import com.carpour.nameverif.APIs.FloodGateUtils;
import com.carpour.nameverif.APIs.GeyserUtil;
import com.carpour.nameverif.Commands.CommandManager;
import com.carpour.nameverif.Events.onJoin;
import com.carpour.nameverif.Utils.Metrics;
import de.jeff_media.updatechecker.UpdateChecker;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Objects;

public final class Main extends JavaPlugin {

    private static Main instance;

    private final List<String> blacklistedNames = getConfig().getStringList("Blacklisted-Names");
    private final List<String> whitelistedNames = getConfig().getStringList("Whitelist-Names.Whitelisted-Names");
    private final boolean isSwitched = getConfig().getBoolean("Whitelist-Names.Enable");

    @Override
    public void onEnable() {

        instance = this;

        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new onJoin(), this);

        Objects.requireNonNull(getCommand("nameverif")).setExecutor(new CommandManager());

        //bstats

        new Metrics(this, 12610);

        //Update Checker
        int resource_ID = 95719;
        UpdateChecker.init(this, resource_ID)
                .checkEveryXHours(2)
                .setChangelogLink(resource_ID)
                .setNotifyOpsOnJoin(true)
                .checkNow();

        if (GeyserUtil.getGeyserAPI() != null){

            getServer().getLogger().info("[Name-Verification] Geyser Plugin Detected!");

        }

        if (FloodGateUtils.getFloodGateAPI()){

            getServer().getLogger().info("[Name-Verification] Floodgate Plugin Detected!");

        }

        getServer().getLogger().info("[Name-Verification] " + ChatColor.GREEN + "Plugin Enabled!");

    }

    public static Main getInstance() { return instance; }

    @Override
    public void onDisable() {

        getServer().getLogger().info("[Name-Verification] " + ChatColor.RED + "Plugin Disabled!");

    }

    public List<String> getBlacklistedNames(){ return blacklistedNames; }

    public List<String> getWhitelistedNames() { return whitelistedNames; }

    public boolean getSwitched(){ return isSwitched; }
}
