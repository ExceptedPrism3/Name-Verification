package com.carpour.nameverif.Commands.OnSubCommands;

import com.carpour.nameverif.Commands.SubCommands;
import com.carpour.nameverif.Main;
import org.bukkit.command.CommandSender;

import java.util.Objects;

public class Reload extends SubCommands {

    Main main = Main.getInstance();

    @Override
    public String getName() { return "reload";  }

    @Override
    public String getDescription() {
        return "Reloads the Plugin.";
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

            main.reloadConfig();
            sender.sendMessage(Objects.requireNonNull(main.getConfig().getString("Messages.Reload-Message")).replaceAll("&", "§"));
        }
    }
}
