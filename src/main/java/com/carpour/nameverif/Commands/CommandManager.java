package com.carpour.nameverif.Commands;

import com.carpour.nameverif.Commands.OnSubCommands.*;
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

        subCommands.add(new AddBlackList());
        subCommands.add(new RemoveBlackList());
        subCommands.add(new ListBlacklist());
        subCommands.add(new WhiteListToggle());
        subCommands.add(new AddWhiteList());
        subCommands.add(new RemoveWhiteList());
        subCommands.add(new ListWhitelist());
        subCommands.add(new Reload());

    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender.hasPermission("nameverif.admin")) {

            if (args.length > 0) {

                for (int i = 0; i < getSubCommands().size(); i++) {

                    if (args[0].equalsIgnoreCase(getSubCommands().get(i).getName())) {

                        getSubCommands().get(i).perform(sender, args);

                    }
                }

            } else {

                sender.sendMessage(ChatColor.BLUE + "----------------------------");

                for (int i = 0; i < getSubCommands().size(); i++) {

                    sender.sendMessage(ChatColor.AQUA + getSubCommands().get(i).getSyntax() +
                            ChatColor.BLUE + " - " + ChatColor.RESET + getSubCommands().get(i).getDescription());

                }

                sender.sendMessage(ChatColor.BLUE + "----------------------------");

            }
        }else{

            sender.sendMessage(Objects.requireNonNull(Main.getInstance().getConfig().getString("Messages.No-Permission")).replaceAll("&", "§"));
            return false;
        }

        return true;
    }

    public ArrayList<SubCommands> getSubCommands() { return subCommands; }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {

        if (args.length == 1){

            ArrayList<String> subCommandsArgs = new ArrayList<>();

            for (int i = 0; i < getSubCommands().size(); i++) {

                subCommandsArgs.add(getSubCommands().get(i).getName());
                
            }

            return subCommandsArgs;

        }

        return null;
    }
}
