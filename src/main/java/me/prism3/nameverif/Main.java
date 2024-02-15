package me.prism3.nameverif;

import me.prism3.nameverif.commands.CommandManager;
import me.prism3.nameverif.utils.Data;
import me.prism3.nameverif.utils.Log;
import me.prism3.nameverif.utils.Metrics;
import de.jeff_media.updatechecker.UpdateChecker;
import org.bukkit.plugin.java.JavaPlugin;

import static me.prism3.nameverif.utils.ASCIIArt.paint;


public final class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {

        instance = this;

        this.saveDefaultConfig();

        Log.setup(this.getLogger());

        this.dataInitializer();

        // bStats
        new Metrics(this, 12610);

        paint();

        // Update Checker
        int resourceID = 95719;
        UpdateChecker.init(this, resourceID)
                .checkEveryXHours(4)
                .setChangelogLink(resourceID)
                .setNotifyOpsOnJoin(true)
                .checkNow();

        Log.info("Plugin Enabled!");
    }

    @Override
    public void onDisable() { Log.info("Plugin Disabled!"); }

    public void dataInitializer() {

        Data.initializeStrings();
        Data.initializeListOfStrings();
        Data.initializeBooleans();
        Data.initializeIntegers();
        Data.initializeEvents();
        Data.initializeHooks();
        Data.initializePermissions();
        this.getCommand("nameverif").setExecutor(new CommandManager());
    }

    public static Main getInstance() { return instance; }
}
