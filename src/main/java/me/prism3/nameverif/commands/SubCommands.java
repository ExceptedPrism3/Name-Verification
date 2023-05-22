package me.prism3.nameverif.commands;

import org.bukkit.command.CommandSender;

import java.util.List;


/**
 * Interface class that contains helper methods that will be used in this plugin's commands.
 */
public interface SubCommands {

    // Get the command name
    String getName();

    // Get the command description
    String getDescription();

    // Get the command syntax
    String getSyntax();

    // Method to execute the command
    void perform(final CommandSender commandSender, final String[] args);

    // Args for additional options for the command
    List<String> getSubCommandsArgs(final CommandSender player, final String[] args);
}
