package com.carpour.nameverif.Commands;

import com.carpour.nameverif.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

import static org.bukkit.Bukkit.getServer;

public class onNameCommand implements CommandExecutor {

    private final Main plugin = Main.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 0 && !args[0].equalsIgnoreCase("Reload")) {

            sender.sendMessage(Objects.requireNonNull(plugin.getConfig().getString("Messages.Invalid-Syntax")).replaceAll("&", "§"));

            return false;
        } else if (args.length == 1 && args[0].equalsIgnoreCase("Reload")) {

            if (sender instanceof Player) {

                if (sender.hasPermission("nameverif.reload")) {

                    plugin.reloadConfig();
                    sender.sendMessage(Objects.requireNonNull(plugin.getConfig().getString("Messages.Reload-Message")).replaceAll("&", "§"));

                } else {

                    sender.sendMessage(Objects.requireNonNull(plugin.getConfig().getString("Messages.No-Permission")).replaceAll("&", "§"));

                }

            } else {

                plugin.reloadConfig();
                getServer().getConsoleSender().sendMessage(Objects.requireNonNull(plugin.getConfig().getString("Messages.Reload-Message")).replaceAll("&", "§"));

            }
            return true;

        } else if (args.length > 1 && args[0].equalsIgnoreCase("Reload")) {

            sender.sendMessage(Objects.requireNonNull(plugin.getConfig().getString("Messages.Invalid-Syntax")).replaceAll("&", "§"));

            return false;
        }

        if (!(sender instanceof Player)){

            getServer().getConsoleSender().sendMessage("\n\n" + ChatColor.YELLOW + "Thank you for using the Name Verification Plugin!\n");

        }

        return false;

    }
}
