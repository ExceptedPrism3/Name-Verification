package com.carpour.nameverif.Commands;

import org.bukkit.command.CommandSender;

public abstract class SubCommands {

    public abstract String getName();

    public abstract String getDescription();

    public abstract String getSyntax();

    public abstract void perform(CommandSender sender, String[] args);

}
