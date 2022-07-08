package me.prism3.nameverif.events;

import me.prism3.nameverif.api.FloodGateUtils;
import me.prism3.nameverif.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.geysermc.floodgate.api.FloodgateApi;

import java.util.*;

public class OnJoin implements Listener {

    private final Main main = Main.getInstance();

    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent e) {

        final Player player = e.getPlayer();
        String playerName = player.getName();
        final List<String> whitelistedNames = this.main.getWhitelistedNames();

        if (player.hasPermission("nameverif.admin") || player.hasPermission("nameverif.bypass")) return;

        if (FloodGateUtils.getFloodGateAPI()) {

            final UUID playerUUID = player.getUniqueId();

            final boolean isBedRock = FloodgateApi.getInstance().isFloodgatePlayer(playerUUID);

            if (isBedRock) {

                final String playerPrefix = FloodgateApi.getInstance().getPlayerPrefix();

                playerName = playerName.replace(" ", playerPrefix);
            }
        }

        if (this.main.getConfig().getBoolean("Whitelist-Names.Enable")) {

            if (!whitelistedNames.contains(playerName)) {

                player.kickPlayer(ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("Messages.Kick-Message")));

            }

            return;
        }

        playerName = playerName.toLowerCase().replaceAll("(.)\1{2,}", "$0").replaceAll("[0-9-_]", "");

        final List<String> names = this.main.getBlacklistedNames();
        names.replaceAll(String::toLowerCase);

        if (names.contains(playerName)) {

            player.kickPlayer(ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("Messages.Kick-Message")));
        }
    }
}
