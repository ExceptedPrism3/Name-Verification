package me.prism3.nameverif.commands.onsubcommands;

import me.prism3.nameverif.Main;
import me.prism3.nameverif.commands.SubCommands;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static me.prism3.nameverif.utils.Data.blacklistedNames;
import static me.prism3.nameverif.utils.Data.whitelistedNames;


/**
 * This class is responsible for modifying the list of the blacklist or whitelist in the config file.
 */
public class ModifyList implements SubCommands {

    private final Main main = Main.getInstance();

    /**
     * Returns the name of the command.
     *
     * @return The name of the command.
     */
    @Override
    public String getName() { return "modifylist"; }


    /**
     * Returns the description of the command.
     *
     * @return The description of the command.
     */
    @Override
    public String getDescription() { return "Add or remove a name from a list."; }

    /**
     * Returns the syntax of the command.
     *
     * @return The syntax of the command.
     */
    @Override
    public String getSyntax() { return "/nameverif " + getName() + " <type> <action> <name>"; }

    /**
     * Adds or removes a name from the specified list.
     *
     * @param sender      The command sender.
     * @param list        The list to modify.
     * @param configPath  The path to the list in the config file.
     * @param name        The name to add or remove.
     * @param isAddAction Whether the action is adding or removing.
     */
    private void modifyList(CommandSender sender, List<String> list, String configPath, String name, boolean isAddAction) {

        if (isAddAction) {

            if (list.contains(name)) {
                sender.sendMessage(ChatColor.AQUA + name + ChatColor.RED + " already exists in the list");
                return;
            }

            list.add(name);
            sender.sendMessage(ChatColor.AQUA + name + ChatColor.GREEN + " was added to the list");

        } else {

            if (!list.contains(name)) {
                sender.sendMessage(ChatColor.AQUA + name + ChatColor.RED + " does not exist in the list");
                return;
            }

            list.remove(name);
            sender.sendMessage(ChatColor.GREEN + name + " was removed from the list");
        }

        main.getConfig().set(configPath, list);
        main.saveConfig();
    }

    /**
     * Performs the specified subcommand.
     *
     * @param sender The command sender.
     * @param args   The subcommand arguments.
     */
    @Override
    public void perform(final CommandSender sender, final String[] args) {

        if (args.length < 4) {
            sender.sendMessage(ChatColor.RED + "Invalid syntax! Please provide a name type (blacklist or whitelist), an action (add or remove), and a name.");
            return;
        }

        final String type = args[1].toLowerCase();
        final String action = args[2].toLowerCase();
        final String name = args[3];

        final List<String> list;
        final String configPath;

        switch (type) {
            case "blacklist":
                list = blacklistedNames;
                configPath = "Blacklisted-Names";
                break;
            case "whitelist":
                list = whitelistedNames;
                configPath = "Whitelist-Names";
                break;
            default:
                sender.sendMessage(ChatColor.RED + "Invalid name type! Please provide either 'blacklist' or 'whitelist'.");
                return;
        }

        switch (action) {
            case "add":
                modifyList(sender, list, configPath, name, true);
                break;
            case "remove":
                modifyList(sender, list, configPath, name, false);
                break;
            default:
                sender.sendMessage(ChatColor.RED + "Invalid action! Please provide either 'add' or 'remove'.");
        }
    }

    /**
     * Returns a list of valid subcommand arguments for the specified command sender and arguments.
     *
     * @param commandSender The command sender.
     * @param args          The arguments.
     * @return A list of valid subcommand arguments.
     */
    @Override
    public List<String> getSubCommandsArgs(final CommandSender commandSender, final String[] args) {

        if (args.length == 2) {

            return Arrays.asList("blacklist", "whitelist");

        } else if (args.length == 3) {

            final String type = args[1].toLowerCase();

            if (type.equalsIgnoreCase("blacklist") || type.equalsIgnoreCase("whitelist"))
                return Arrays.asList("add", "remove");
        }

        return Collections.emptyList();
    }
}
