package com.carpour.nameverif.Commands.OnSubCommands;

import com.carpour.nameverif.Commands.SubCommands;
import com.carpour.nameverif.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.List;
import java.util.Objects;

public class AddBlackList extends SubCommands {

    Main main = Main.getInstance();

    List<String> blacklistedNames = main.getBlacklistedNames();

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

        if (args.length > 2){

            sender.sendMessage(Objects.requireNonNull(main.getConfig().getString("Messages.Invalid-Syntax")).replaceAll("&", "§"));

        } else if (args.length > 1){

            String name = args[1];

            if (!blacklistedNames.contains(name)) {

                blacklistedNames.add(name);

                main.getConfig().set("Blacklisted-Names", blacklistedNames);
                main.saveConfig();

                sender.sendMessage(ChatColor.AQUA + name + ChatColor.GREEN + " was added to the list");

            }else{

                sender.sendMessage(ChatColor.AQUA + name + ChatColor.RED + " Already exists in the list");

            }

        }else if (args.length == 1){

            sender.sendMessage(ChatColor.RED + "You need to provide a name!");

        }
    }
}
