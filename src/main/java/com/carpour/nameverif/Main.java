package com.carpour.nameverif;

import com.carpour.nameverif.api.FloodGateUtils;
import com.carpour.nameverif.api.GeyserUtil;
import com.carpour.nameverif.commands.CommandManager;
import com.carpour.nameverif.events.OnJoin;
import com.carpour.nameverif.utils.Metrics;
import de.jeff_media.updatechecker.UpdateChecker;
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

        this.saveDefaultConfig();

        this.getServer().getPluginManager().registerEvents(new OnJoin(), this);

        Objects.requireNonNull(getCommand("nameverif")).setExecutor(new CommandManager());

        // bStats

        new Metrics(this, 12610);

        //Update Checker
        int resourceID = 95719;
        UpdateChecker.init(this, resourceID)
                .checkEveryXHours(4)
                .setChangelogLink(resourceID)
                .setNotifyOpsOnJoin(true)
                .checkNow();

        if (GeyserUtil.getGeyserAPI() != null){

            this.getServer().getLogger().info("[Name-Verification] Geyser Plugin Detected!");

        }

        if (FloodGateUtils.getFloodGateAPI()){

            this.getServer().getLogger().info("[Name-Verification] Floodgate Plugin Detected!");

        }

        this.getServer().getLogger().info("[Name-Verification] Plugin Enabled!");

    }

    @Override
    public void onDisable() {

        this.getServer().getLogger().info("[Name-Verification] Plugin Disabled!");

    }

    public static Main getInstance() { return instance; }

    public List<String> getBlacklistedNames(){ return this.blacklistedNames; }

    public List<String> getWhitelistedNames() { return this.whitelistedNames; }

    public boolean getSwitched(){ return this.isSwitched; }
}
