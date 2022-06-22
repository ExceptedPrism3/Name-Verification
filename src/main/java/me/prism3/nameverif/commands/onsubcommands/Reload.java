package me.prism3.nameverif.commands.onsubcommands;

import me.prism3.nameverif.commands.SubCommands;
import me.prism3.nameverif.Main;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Reload implements SubCommands {

    private final Main main = Main.getInstance();

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

        if (args.length > 1 || !(args[0].equalsIgnoreCase(getName()))) {

            sender.sendMessage(Objects.requireNonNull(this.main.getConfig().getString("Messages.Invalid-Syntax")).replace("&", "§"));

        } else {

            this.main.reloadConfig();
            sender.sendMessage(Objects.requireNonNull(this.main.getConfig().getString("Messages.Reload-Message")).replace("&", "§"));
        }
    }

    @Override
    public List<String> getSubCommandsArgs(Player player, String[] args) { return Collections.emptyList(); }
}
