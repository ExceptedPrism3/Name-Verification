package com.carpour.nameverif.commands;

import com.carpour.nameverif.commands.onsubcommands.*;
import com.carpour.nameverif.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CommandManager implements TabExecutor {

    private final ArrayList<SubCommands> subCommands = new ArrayList<>();

    public CommandManager(){

        this.subCommands.add(new AddBlackList());
        this.subCommands.add(new RemoveBlackList());
        this.subCommands.add(new ListBlacklist());
        this.subCommands.add(new WhiteListToggle());
        this.subCommands.add(new AddWhiteList());
        this.subCommands.add(new RemoveWhiteList());
        this.subCommands.add(new ListWhitelist());
        this.subCommands.add(new Reload());

    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender.hasPermission("nameverif.admin")) {

            if (args.length > 0) {

                for (int i = 0; i < this.getSubCommands().size(); i++) {

                    if (args[0].equalsIgnoreCase(this.getSubCommands().get(i).getName())) {

                        this.getSubCommands().get(i).perform(sender, args);

                    }
                }

            } else {

                sender.sendMessage(ChatColor.BLUE + "----------------------------");

                for (int i = 0; i < this.getSubCommands().size(); i++) {

                    sender.sendMessage(ChatColor.AQUA + this.getSubCommands().get(i).getSyntax() +
                            ChatColor.BLUE + " - " + ChatColor.RESET + this.getSubCommands().get(i).getDescription());

                }

                sender.sendMessage(ChatColor.BLUE + "----------------------------");

            }
        }else{

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Main.getInstance().getConfig().getString("Messages.No-Permission"))));
            return false;
        }

        return true;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {

        if (args.length == 1){

            final ArrayList<String> subCommandsArgs = new ArrayList<>();

            for (int i = 0; i < this.getSubCommands().size(); i++) {

                subCommandsArgs.add(this.getSubCommands().get(i).getName());
                
            }

            return subCommandsArgs;

        }

        return null;
    }

    public List<SubCommands> getSubCommands() { return this.subCommands; }
}
