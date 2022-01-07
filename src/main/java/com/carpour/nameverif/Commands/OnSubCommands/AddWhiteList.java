package com.carpour.nameverif.Commands.OnSubCommands;

import com.carpour.nameverif.Commands.SubCommands;
import com.carpour.nameverif.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.List;
import java.util.Objects;

public class AddWhiteList extends SubCommands {

    Main main = Main.getInstance();

    List<String> whitelistedNames = main.getWhitelistedNames();

    @Override
    public String getName() {
        return "add-whitelist";
    }

    @Override
    public String getDescription() {
        return "Add Names into Whitelist Field.";
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

            if (!whitelistedNames.contains(name)) {

                whitelistedNames.add(name);

                main.getConfig().set("Whitelist-Names.Whitelisted-Names", whitelistedNames);
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
