package com.carpour.nameverif.Commands.OnSubCommands;

import com.carpour.nameverif.Commands.SubCommands;
import com.carpour.nameverif.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.Objects;

public class WhiteListToggle extends SubCommands {

    Main main = Main.getInstance();

    private boolean isSwitched = main.getSwitched();

    @Override
    public String getName() {
        return "toggle";
    }

    @Override
    public String getDescription() {
        return "Toggles the Whitelist Mode.";
    }

    @Override
    public String getSyntax() {
        return "/nameverif " + getName();
    }

    @Override
    public void perform(CommandSender sender, String[] args) {

        if (args.length > 1 || !(args[0].equalsIgnoreCase(getName()))){

            sender.sendMessage(Objects.requireNonNull(main.getConfig().getString("Messages.Invalid-Syntax")).replaceAll("&", "§"));

        } else if (!isSwitched){

            isSwitched = true;

            main.getConfig().set("Whitelist-Names.Enable", true);
            main.getConfig().options().copyDefaults(true);
            main.saveConfig();

            sender.sendMessage(ChatColor.GREEN + "Whitelist Mode On");

        }else {

            isSwitched = false;

            main.getConfig().set("Whitelist-Names.Enable", false);
            main.getConfig().options().copyDefaults(true);
            main.saveConfig();

            sender.sendMessage(ChatColor.RED + "Whitelist Mode Off");
        }
    }
}
