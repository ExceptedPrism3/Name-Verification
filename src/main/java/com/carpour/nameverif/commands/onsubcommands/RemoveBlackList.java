package com.carpour.nameverif.commands.onsubcommands;

import com.carpour.nameverif.commands.SubCommands;
import com.carpour.nameverif.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class RemoveBlackList implements SubCommands {

    private final Main main = Main.getInstance();
    private final List<String> blacklistedNames = this.main.getBlacklistedNames();

    @Override
    public String getName() {
        return "remove-blacklist";
    }

    @Override
    public String getDescription() {
        return "Remove the name from blacklist field.";
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

            if (this.blacklistedNames.contains(name)) {

                this.blacklistedNames.remove(name);
                this.main.getConfig().set("Blacklisted-Names", this.blacklistedNames);
                this.main.saveConfig();

                sender.sendMessage(ChatColor.GREEN + name + " was removed from the list");

            } else {

                sender.sendMessage(ChatColor.RED + name + " does not exist in list");

            }
        } else if (args.length == 1) {

            sender.sendMessage(ChatColor.RED + "You need to provide a name!");

        }
    }

    @Override
    public List<String> getSubCommandsArgs(Player player, String[] args) { return Collections.emptyList(); }
}
