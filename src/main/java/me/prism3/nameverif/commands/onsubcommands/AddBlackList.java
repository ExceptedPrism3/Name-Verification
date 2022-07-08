package me.prism3.nameverif.commands.onsubcommands;

import me.prism3.nameverif.commands.SubCommands;
import me.prism3.nameverif.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public class AddBlackList implements SubCommands {

    private final Main main = Main.getInstance();
    private final List<String> blacklistedNames = this.main.getBlacklistedNames();

    @Override
    public String getName() {
        return "add-blacklist";
    }

    @Override
    public String getDescription() {
        return "Add the name into blacklist field.";
    }

    @Override
    public String getSyntax() {
        return "/nameverif " + getName() + " <name>";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {

        if (args.length > 2) {

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("Messages.Invalid-Syntax")));

        } else if (args.length > 1) {

            final String name = args[1];

            if (!this.blacklistedNames.contains(name)) {

                this.blacklistedNames.add(name);

                this.main.getConfig().set("Blacklisted-Names", this.blacklistedNames);
                this.main.saveConfig();

                sender.sendMessage(ChatColor.AQUA + name + ChatColor.GREEN + " was added to the list");

            } else {

                sender.sendMessage(ChatColor.AQUA + name + ChatColor.RED + " Already exists in the list");

            }

        } else if (args.length == 1) {

            sender.sendMessage(ChatColor.RED + "You need to provide a name!");

        }
    }

    @Override
    public List<String> getSubCommandsArgs(Player player, String[] args) { return Collections.emptyList(); }
}
