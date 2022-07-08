package me.prism3.nameverif.commands.onsubcommands;

import me.prism3.nameverif.commands.SubCommands;
import me.prism3.nameverif.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public class WhiteListToggle implements SubCommands {

    private final Main main = Main.getInstance();
    private boolean isSwitched = this.main.getSwitched();

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

        if (args.length > 1 || !(args[0].equalsIgnoreCase(getName()))) {

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("Messages.Invalid-Syntax")));

        } else if (!isSwitched) {

            isSwitched = true;

            main.getConfig().set("Whitelist-Names.Enable", true);
            main.getConfig().options().copyDefaults(true);
            main.saveConfig();

            sender.sendMessage(ChatColor.GREEN + "Whitelist Mode On");

        } else {

            isSwitched = false;

            main.getConfig().set("Whitelist-Names.Enable", false);
            main.getConfig().options().copyDefaults(true);
            main.saveConfig();

            sender.sendMessage(ChatColor.RED + "Whitelist Mode Off");
        }
    }

    @Override
    public List<String> getSubCommandsArgs(Player player, String[] args) { return Collections.emptyList(); }
}
