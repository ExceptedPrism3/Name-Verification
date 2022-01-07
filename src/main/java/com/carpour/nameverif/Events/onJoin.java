package com.carpour.nameverif.Events;

import com.carpour.nameverif.APIs.FloodGateUtils;
import com.carpour.nameverif.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.geysermc.floodgate.api.FloodgateApi;

import java.util.*;

public class onJoin implements Listener {

    private final Main main = Main.getInstance();

    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent e){

        Player player = e.getPlayer();
        String playerName = player.getName();
        List<String> names = main.getBlacklistedNames();
        List<String> whitelistedNames = main.getWhitelistedNames();
        names.replaceAll(String::toLowerCase);

        if (player.hasPermission("nameverif.admin") || player.hasPermission("nameverif.bypass")) return;

        if (FloodGateUtils.getFloodGateAPI()) {

            UUID playerUUID = player.getUniqueId();

            boolean isBedRock = FloodgateApi.getInstance().isFloodgatePlayer(playerUUID);

            if (isBedRock) {

                String playerPrefix = FloodgateApi.getInstance().getPlayerPrefix();

                playerName = playerName.replaceAll(" ", playerPrefix);
            }
        }

        if (main.getConfig().getBoolean("Whitelist-Names.Enable")) {

            if (!whitelistedNames.contains(playerName)) {

                player.kickPlayer(Objects.requireNonNull(main.getConfig().getString("Messages.Kick-Message")).replaceAll("&", "§"));

            }

            return;
        }

        playerName = playerName.toLowerCase();

        if (names.contains(playerName)) {

            player.kickPlayer(Objects.requireNonNull(main.getConfig().getString("Messages.Kick-Message")).replaceAll("&", "§"));
        }
    }
}
