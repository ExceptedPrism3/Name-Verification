package me.prism3.nameverif.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/**
 * Tracks the number of attempts a player makes to join the server with a blacklisted name.
 * If the number of attempts exceeds a predefined limit, the player is banned.
 */
public class AttemptTracker {

    // Map to keep track of join attempts by each player, identified by their UUID.
    private final Map<UUID, Integer> attempts = new HashMap<>();

    /**
     * Records an attempt to join the server and bans the player if the number of attempts
     * exceeds the allowed limit.
     *
     * @param player The player who is trying to join.
     */
    public void recordAttempt(final Player player) {

        final UUID playerId = player.getUniqueId();

        // Increment the number of attempts for this player.
        attempts.put(playerId, attempts.getOrDefault(playerId, 0) + 1);

        // Check if the number of attempts exceeds the limit.
        if (attempts.get(playerId) >= Data.banAttempts) {

            // Ban the player and kick them with a specified message.
            Bukkit.getBanList(org.bukkit.BanList.Type.NAME).addBan(player.getName(), Data.banMessage, null, null);
            player.kickPlayer(Data.banMessage);

            // Reset the attempt count for this player after banning.
            attempts.remove(playerId);
        }
    }
}
