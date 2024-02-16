package me.prism3.nameverif.utils;

import me.prism3.nameverif.Main;
import me.prism3.nameverif.events.OnJoin;
import me.prism3.nameverif.events.OnLeave;
import me.prism3.nameverif.hooks.BedRockPlayerChecker;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


/**
 * Utility class for managing plugin data and initialization.
 */
public class Data {

    private static final Main main = Main.getInstance();

    // Configuration keys
    private static final String KICK_MESSAGE_KEY = "Messages.Kick";
    private static final String NO_PERMISSION_MESSAGE_KEY = "Messages.No-Permission";
    private static final String RELOAD_MESSAGE_KEY = "Messages.Reload";
    private static final String INVALID_SYNTAX_MESSAGE_KEY = "Messages.Invalid-Syntax";
    private static final String BAN_REASON_KEY = "Messages.Reason";
    private static final String PLUGIN_PREFIX_KEY = "Messages.Prefix";
    private static final String WHITELISTED_NAMES_KEY = "Whitelist-Names.Whitelisted-Names";
    private static final String BLACKLISTED_NAMES_KEY = "Blacklisted-Names";
    private static final String SWITCHED_KEY = "Whitelist-Names.Enable";
    private static final String BAN_KEY = "Ban.Enabled";

    public static String kickMessage;
    public static String reloadMessage;
    public static String noPermissionMessage;
    public static String invalidSyntaxMessage;
    public static String banReason;
    public static String banCommand;
    public static String pluginName;
    public static String pluginPrefix;
    public static String pluginVersion;

    public static List<String> blacklistedNames;
    public static List<Pattern> blacklistedPatterns;

    public static List<String> whitelistedNames;

    public static boolean isSwitched;
    public static boolean isGeyserPresent;
    public static boolean isBanEnabled;

    public static int banAttempts;

    public static String nameVerifAdmin;
    public static String nameVerifBypass;

    private Data() {}

    /**
     * Initializes string values from the plugin configuration.
     */
    public static void initializeStrings() {

        pluginPrefix = getConfigString(PLUGIN_PREFIX_KEY);
        kickMessage = getConfigString(KICK_MESSAGE_KEY).replace("%prefix%", pluginPrefix);
        noPermissionMessage = getConfigString(NO_PERMISSION_MESSAGE_KEY).replace("%prefix%", pluginPrefix);
        reloadMessage = getConfigString(RELOAD_MESSAGE_KEY).replace("%prefix%", pluginPrefix);
        invalidSyntaxMessage = getConfigString(INVALID_SYNTAX_MESSAGE_KEY).replace("%prefix%", pluginPrefix);
        banReason = getConfigString(BAN_REASON_KEY).replace("%prefix%", pluginPrefix);
        banCommand = getConfigString("Ban.Command").replace("%reason%", banReason);
        pluginName = main.getDescription().getName();
        pluginVersion = main.getDescription().getVersion();
    }

    /**
     * Initializes lists of strings from the plugin configuration.
     */
    public static void initializeListOfStrings() {

        whitelistedNames = main.getConfig().getStringList(WHITELISTED_NAMES_KEY);
        blacklistedNames = main.getConfig().getStringList(BLACKLISTED_NAMES_KEY);

        final List<String> blacklistWords = main.getConfig().getStringList(BLACKLISTED_NAMES_KEY);
        blacklistedPatterns = blacklistWords.stream()
                .map(word -> {
                    String regexPart = word.chars()
                            .mapToObj(i -> Pattern.quote(String.valueOf((char) i)) + (Character.isDigit(i) ? "" : "\\W*"))
                            .collect(Collectors.joining());
                    String pattern = "\\b" + regexPart + "\\b";
                    if (word.matches("^\\d+$")) { // Strictly numeric
                        pattern = "\\b" + regexPart + "(?!\\w)";
                    }
                    return Pattern.compile(pattern, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS);
                })
                .collect(Collectors.toList());
    }

    /**
     * Initializes boolean values from the plugin configuration.
     */
    public static void initializeBooleans() {
        isSwitched = main.getConfig().getBoolean(SWITCHED_KEY);
        isBanEnabled = main.getConfig().getBoolean(BAN_KEY);
    }

    public static void initializeIntegers() { banAttempts = main.getConfig().getInt("Ban.Attempts"); }

    /**
     * Initializes event listeners for the plugin.
     */
    public static void initializeEvents() {
        main.getServer().getPluginManager().registerEvents(new OnJoin(), main);
        main.getServer().getPluginManager().registerEvents(new OnLeave(), main);
    }

    /**
     * Initializes plugin hooks.
     */
    public static void initializeHooks() { if (BedRockPlayerChecker.isGeyserFloodGateHookEnabled())  isGeyserPresent = true; }

    /**
     * Initializes permission strings.
     */
    public static void initializePermissions() {
        nameVerifAdmin = "nameverif.admin";
        nameVerifBypass = "nameverif.bypass";
    }

    /**
     * Retrieves a string value from the plugin configuration.
     *
     * @param key the configuration key
     * @return the string value from the configuration, or an empty string if not found
     */
    private static String getConfigString(final String key) { return main.getConfig().getString(key, "")
            .replace("&", "§"); }
}
