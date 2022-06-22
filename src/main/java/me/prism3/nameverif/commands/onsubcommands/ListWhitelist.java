package me.prism3.nameverif.commands.onsubcommands;

import me.prism3.nameverif.commands.SubCommands;
import me.prism3.nameverif.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ListWhitelist implements SubCommands {

    private final Main main = Main.getInstance();
    private final List<String> whitelistList = this.main.getWhitelistedNames();

    @Override
    public String getName() {
        return "list-whitelist";
    }

    @Override
    public String getDescription() {
        return "Lists all stored whitelisted names.";
    }

    @Override
    public String getSyntax() {
        return "/nameverif " + getName();
    }

    @Override
    public void perform(CommandSender sender, String[] args) {

        if (args.length > 1 || !(args[0].equalsIgnoreCase(getName()))) {

            sender.sendMessage(Objects.requireNonNull(this.main.getConfig().getString("Messages.Invalid-Syntax")).replace("&", "§"));

        } else {

            sender.sendMessage(ChatColor.AQUA + "Whitelisted Names:");

            this.whitelistList.forEach(sender::sendMessage);

        }
    }

    @Override
    public List<String> getSubCommandsArgs(Player player, String[] args) { return Collections.emptyList(); }
}
