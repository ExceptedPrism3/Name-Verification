package com.carpour.nameverif.Commands.OnSubCommands;

import com.carpour.nameverif.Commands.SubCommands;
import com.carpour.nameverif.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.List;
import java.util.Objects;

public class ListBlacklist extends SubCommands {

    Main main = Main.getInstance();

    List<String> blacklistList = main.getBlacklistedNames();

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

        if (args.length > 1 || !(args[0].equalsIgnoreCase(getName()))){

            sender.sendMessage(Objects.requireNonNull(main.getConfig().getString("Messages.Invalid-Syntax")).replaceAll("&", "§"));

        } else {

            sender.sendMessage(ChatColor.AQUA + "Blacklisted Names:");

            blacklistList.forEach(sender::sendMessage);

        }
    }
}
