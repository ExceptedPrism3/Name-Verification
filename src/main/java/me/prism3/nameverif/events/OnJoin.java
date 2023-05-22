package me.prism3.nameverif.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.geysermc.floodgate.api.FloodgateApi;

import static me.prism3.nameverif.utils.Data.*;


/**
 * Represents the event listener for player join events.
 */
public class OnJoin implements Listener {

    /**
     * Handles the player join event.
     *
     * @param event The PlayerJoinEvent.
     */
    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent event) {

        final Player player = event.getPlayer();

        if (player.hasPermission(nameVerifBypass))
            return;

        final String playerName = player.getName().toLowerCase().replaceAll("(.)\\1{2,}|[0-9-_]", "$0");

        if (isGeyserPresent)
            this.applyBedrockChecker(player);

        if (isSwitched && whitelistedNames.stream().noneMatch(name -> name.equalsIgnoreCase(playerName))) {
            this.kickPlayer(player, event);
            return;
        }

        if (blacklistedNames.stream().anyMatch(name -> name.equalsIgnoreCase(playerName)))
            this.kickPlayer(player, event);
    }

    /**
     * Applies the Bedrock checker to the player if Geyser is present.
     *
     * @param player The player to apply the Bedrock checker to.
     */
    private void applyBedrockChecker(final Player player) {

        final FloodgateApi floodgateApi = FloodgateApi.getInstance();

        if (floodgateApi.isFloodgatePlayer(player.getUniqueId())) {

            final String playerPrefix = floodgateApi.getPlayerPrefix();

            player.setDisplayName(player.getDisplayName().replace(" ", playerPrefix));
        }
    }

    /**
     * Kicks the player with the configured kick message.
     *
     * @param player The player to kick.
     */
    private void kickPlayer(final Player player, final PlayerJoinEvent event) {
        player.kickPlayer(ChatColor.translateAlternateColorCodes('&', kickMessage));
        this.notifyStaff(player.getName());
    }

    /**
     * Method to notify the admins when a player tries to join with a blacklisted name.
     *
     * @param kickedPlayerName the name of the player that is blacklisted
     */
    private void notifyStaff(final String kickedPlayerName) {
        Bukkit.getOnlinePlayers().stream()
                .filter(player -> player.hasPermission(nameVerifAdmin))
                .forEach(player -> {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            pluginPrefix + " &cA player tried to join with a blacklisted name: " + kickedPlayerName));
                });
    }
}
