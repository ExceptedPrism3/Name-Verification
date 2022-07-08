package me.prism3.nameverif.commands.onsubcommands;

import me.prism3.nameverif.commands.SubCommands;
import me.prism3.nameverif.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public class ListBlacklist implements SubCommands {

    private final Main main = Main.getInstance();
    private final List<String> blacklistList = this.main.getBlacklistedNames();

    @Override
    public String getName() {
        return "list-blacklist";
    }

    @Override
    public String getDescription() {
        return "Lists all stored blacklisted names.";
    }

    @Override
    public String getSyntax() {
        return "/nameverif " + getName();
    }

    @Override
    public void perform(CommandSender sender, String[] args) {

        if (args.length > 1 || !(args[0].equalsIgnoreCase(getName()))) {

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("Messages.Invalid-Syntax")));

        } else {

            sender.sendMessage(ChatColor.AQUA + "Blacklisted Names:");

            this.blacklistList.forEach(sender::sendMessage);

        }
    }

    @Override
    public List<String> getSubCommandsArgs(Player player, String[] args) { return Collections.emptyList(); }
}
