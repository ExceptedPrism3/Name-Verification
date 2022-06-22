package me.prism3.nameverif.commands.onsubcommands;

import me.prism3.nameverif.commands.SubCommands;
import me.prism3.nameverif.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class RemoveWhiteList implements SubCommands {

    private final Main main = Main.getInstance();
    private final List<String> whitelistedNames = this.main.getWhitelistedNames();

    @Override
    public String getName() {
        return "remove-whitelist";
    }

    @Override
    public String getDescription() {
        return "Remove the name from whitelist field.";
    }

    @Override
    public String getSyntax() {
        return "/nameverif " + getName() + " <name>";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {

        if (args.length > 2) {

            sender.sendMessage(Objects.requireNonNull(this.main.getConfig().getString("Messages.Invalid-Syntax")).replace("&", "§"));

        } else if (args.length > 1) {

            String name = args[1];

            if (this.whitelistedNames.contains(name)) {

                this.whitelistedNames.remove(name);
                this.main.getConfig().set("Whitelist-Names.Whitelisted-Names", this.whitelistedNames);
                this.main.saveConfig();

                sender.sendMessage(ChatColor.AQUA + name + ChatColor.GREEN + " was removed from the list");

            } else {

                sender.sendMessage(ChatColor.AQUA + name + ChatColor.RED + " does not exist in list");

            }
        } else if (args.length == 1) {

            sender.sendMessage(ChatColor.RED + "You need to provide a name!");

        }
    }

    @Override
    public List<String> getSubCommandsArgs(Player player, String[] args) { return Collections.emptyList(); }
}
