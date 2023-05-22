package me.prism3.nameverif.commands;

import me.prism3.nameverif.commands.onsubcommands.*;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static me.prism3.nameverif.utils.Data.*;


/**
 * A class that manages the commands and sub-commands related to the plugin.
 */
public class CommandManager implements TabExecutor {

    // ArrayList of sub-commands
    private final ArrayList<SubCommands> subCommands = new ArrayList<>();

    /**
     * Initializes the sub-commands list.
     */
    public CommandManager() {

        this.subCommands.add(new ListStrings());
        this.subCommands.add(new ModifyList());
        this.subCommands.add(new WhiteListToggle());
        this.subCommands.add(new Reload());
    }

    /**
     * Executes the given command.
     *
     * @param sender  the sender of the command
     * @param command the command object
     * @param label   the command label
     * @param args    the command arguments
     * @return true if the command was executed successfully
     */
    @Override
    public boolean onCommand(final @NotNull CommandSender sender, final @NotNull Command command, final @NotNull String label, final @NotNull String[] args) {

        // Check if the sender has permission
        if (!sender.hasPermission(nameVerifAdmin)) {

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    noPermissionMessage.replace("%prefix%", pluginPrefix)));

            return false;
        }

        // Check if there are any arguments
        if (args.length > 0) {
            // Check if the first argument matches a sub-command name
            for (int i = 0; i < this.getSubCommands().size(); i++) {

                if (args[0].equalsIgnoreCase(this.getSubCommands().get(i).getName())) {

                    this.getSubCommands().get(i).perform(sender, args);

                }
            }

        } else {
            // If no arguments were given, display the list of sub-commands
            sender.sendMessage("--------------------------------------------");
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "Running " + pluginName + " : &a&l" + pluginVersion));
            for (int i = 0; i < this.getSubCommands().size(); i++)
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&l" + this.getSubCommands().get(i).getSyntax() + " &8&l| &r" + this.getSubCommands().get(i).getDescription()));
            sender.sendMessage("--------------------------------------------");
        }
        return true;
    }

    /**
     * Tab-completes the given command.
     *
     * @param sender  the sender of the command
     * @param command the command object
     * @param alias   the command label
     * @param args    the command arguments
     * @return the list of tab-completion options
     */
    @Nullable
    @Override
    public List<String> onTabComplete(final @NotNull CommandSender sender, final @NotNull Command command, final @NotNull String alias, final @NotNull String[] args) {

        // If there is only one argument, return the list of sub-commands
        if (args.length == 1) {

            final ArrayList<String> subCommandsArgs = new ArrayList<>();

            // Cycle through the sub-commands and add them as args
            for (int i = 0; i < this.getSubCommands().size(); i++)
                subCommandsArgs.add(this.getSubCommands().get(i).getName());

            return subCommandsArgs;

        } else if (args.length > 1) {

            for (int i = 0; i < this.getSubCommands().size(); i++) {

                if (args[0].equalsIgnoreCase(this.getSubCommands().get(i).getName())) {

                    return this.getSubCommands().get(i).getSubCommandsArgs(sender, args);
                }
            }
        }

        return Collections.emptyList();
    }

    /**
     * Gets the list of sub-commands.
     *
     * @return the list of sub-commands
     */
    public List<SubCommands> getSubCommands() { return this.subCommands; }
}
