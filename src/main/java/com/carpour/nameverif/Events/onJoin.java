package com.carpour.nameverif.Events;

import com.carpour.nameverif.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;
import java.util.Objects;

public class onJoin implements Listener {

    private final Main main = Main.getInstance();

    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent e){

        Player player = e.getPlayer();
        String playername = player.getName().toLowerCase();
        List<String> names = main.getConfig().getStringList("Names");
        names.replaceAll(String::toLowerCase);

        if (names.contains(playername.toLowerCase())) {

            player.kickPlayer(Objects.requireNonNull(main.getConfig().getString("Messages.Kick-Message")).replaceAll("&", "§"));
        }

        if (main.getConfig().getBoolean("Bedrock.Enable")){

            playername = playername.replaceAll(" ", Objects.requireNonNull(main.getConfig().getString("Bedrock.Space-Replacement")));

            if (names.contains(playername.toLowerCase())) {

                player.kickPlayer(Objects.requireNonNull(main.getConfig().getString("Messages.Kick-Message")).replaceAll("&", "§"));
            }
        }
    }
}
