package com.carpour.nameverif.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public interface SubCommands {

    String getName();

    String getDescription();

    String getSyntax();

    void perform(CommandSender sender, String[] args);

    List<String> getSubCommandsArgs(Player player, String[] args);

}
