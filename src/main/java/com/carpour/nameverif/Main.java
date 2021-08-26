package com.carpour.nameverif;

import com.carpour.nameverif.Commands.onNameCommand;
import com.carpour.nameverif.Events.onJoin;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {

        instance = this;

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new onJoin(), this);

        Objects.requireNonNull(getCommand("nameverif")).setExecutor(new onNameCommand());

        getServer().getLogger().info("[Name-Verification] " + ChatColor.GREEN + "Plugin Enabled!");

    }

    public static Main getInstance() { return instance; }

    @Override
    public void onDisable() {

        getServer().getLogger().info("[Name-Verification] " + ChatColor.RED + "Plugin Disabled!");

    }
}
