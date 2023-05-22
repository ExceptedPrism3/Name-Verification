package me.prism3.nameverif.commands.onsubcommands;

import me.prism3.nameverif.commands.SubCommands;
import me.prism3.nameverif.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.Collections;
import java.util.List;

import static me.prism3.nameverif.utils.Data.invalidSyntaxMessage;
import static me.prism3.nameverif.utils.Data.reloadMessage;


/**
 * Represents the "reload" subcommand of the NameVerif command.
 */
public class Reload implements SubCommands {

    private final Main main = Main.getInstance();

    /**
     * Returns the name of the subcommand.
     *
     * @return The name of the subcommand.
     */
    @Override
    public String getName() { return "reload"; }

    /**
     * Returns the description of the subcommand.
     *
     * @return The description of the subcommand.
     */
    @Override
    public String getDescription() { return "Reloads the Plugin."; }

    /**
     * Returns the syntax of the subcommand.
     *
     * @return The syntax of the subcommand.
     */
    @Override
    public String getSyntax() { return "/nameverif " + getName(); }

    /**
     * Performs the reload subcommand.
     *
     * @param sender The CommandSender who executed the command.
     * @param args   The command arguments.
     */
    @Override
    public void perform(final CommandSender sender, final String[] args) {

        if (args.length > 1 || !(args[0].equalsIgnoreCase(this.getName()))) {

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', invalidSyntaxMessage));

        } else {

            this.main.reloadConfig();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', reloadMessage));
        }
    }

    /**
     * Returns the list of possible arguments for the subcommand.
     *
     * @param commandSender The CommandSender who executed the command.
     * @param args          The command arguments.
     * @return The list of possible arguments for the subcommand.
     */
    @Override
    public List<String> getSubCommandsArgs(final CommandSender commandSender, final String[] args) { return Collections.emptyList(); }
}
