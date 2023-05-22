package me.prism3.nameverif.commands.onsubcommands;

import me.prism3.nameverif.commands.SubCommands;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static me.prism3.nameverif.utils.Data.blacklistedNames;
import static me.prism3.nameverif.utils.Data.whitelistedNames;


/**
 * Represents the "list" subcommand of the NameVerif command.
 */
public class ListStrings implements SubCommands {

    /**
     * Returns the name of the command.
     *
     * @return The name of the command.
     */
    @Override
    public String getName() { return "list"; }

    /**
     * Returns the description of the command.
     *
     * @return The description of the command.
     */
    @Override
    public String getDescription() { return "Lists all stored names."; }

    /**
     * Returns the syntax of the command.
     *
     * @return The syntax of the command.
     */
    @Override
    public String getSyntax() { return "/nameverif " + this.getName() + " <type>"; }

    /**
     * Performs the command's logic.
     *
     * @param sender The CommandSender executing the command.
     * @param args   The arguments provided with the command.
     */
    @Override
    public void perform(final CommandSender sender, final String[] args) {

        if (args.length < 2) {
            sender.sendMessage(ChatColor.RED + "Invalid syntax! Usage: " + getSyntax());
            return;
        }

        final String type = args[1].toLowerCase();

        if (type.equalsIgnoreCase("blacklist")) {

            this.listNames(sender, "Blacklisted Names", blacklistedNames);

        } else if (type.equalsIgnoreCase("whitelist")) {

            this.listNames(sender, "Whitelisted Names", whitelistedNames);

        } else {
            sender.sendMessage(ChatColor.RED + "Invalid name type! Please provide either 'blacklist' or 'whitelist'.");
        }
    }

    /**
     * Lists the names of the specified type.
     *
     * @param sender The CommandSender to send the list to.
     * @param title  The title of the list.
     * @param names  The list of names to display.
     */
    private void listNames(final CommandSender sender, final String title, final List<String> names) {

        sender.sendMessage(ChatColor.AQUA + title + ":");

        if (names.isEmpty()) {

            sender.sendMessage(ChatColor.GRAY + "No names found.");

        } else {

            names.forEach(sender::sendMessage);
        }
    }

    /**
     * Returns the valid arguments for the command.
     *
     * @param commandSender The CommandSender executing the command.
     * @param args          The arguments provided with the command.
     * @return A list of valid arguments for the command.
     */
    @Override
    public List<String> getSubCommandsArgs(final CommandSender commandSender, final String[] args) {

        if (args.length == 2)
            return Arrays.asList("blacklist", "whitelist");

        return Collections.emptyList();
    }
}
