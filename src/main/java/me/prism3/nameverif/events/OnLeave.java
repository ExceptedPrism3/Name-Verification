package me.prism3.nameverif.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import static me.prism3.nameverif.utils.Data.blacklistedNames;
import static me.prism3.nameverif.utils.Data.nameVerifBypass;

/**
 * Represents the event listener for player leave events.
 */
public class OnLeave implements Listener {

    /**
     * Handles the player leave event.
     *
     * @param event The PlayerQuitEvent.
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerLeave(final PlayerQuitEvent event) {

        final Player player = event.getPlayer();

        if (player.hasPermission(nameVerifBypass))
            return;

        final String playerName = player.getName();

        if (blacklistedNames.stream().anyMatch(name -> name.equalsIgnoreCase(playerName)))
            event.setQuitMessage(null);
    }
}
