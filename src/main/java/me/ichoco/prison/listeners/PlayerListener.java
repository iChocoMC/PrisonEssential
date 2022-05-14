package me.ichoco.prison.listeners;

import me.ichoco.prison.PrisonEssentialPlugin;
import me.ichoco.prison.utils.LocationUtil;
import me.ichoco.prison.utils.MessageUtil;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerListener implements Listener {

    private final FileConfiguration config = PrisonEssentialPlugin.getInstance().getConfig();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(MessageUtil.translate(config.getString("messages.welcome")));
        event.setJoinMessage(MessageUtil.translate(config.getString("messages.join")
                .replace("{player_name}", player.getDisplayName())));
        teleportToSpawn(player);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.setQuitMessage(MessageUtil.translate(config.getString("messages.quit")
                .replace("{player_name}", event.getPlayer().getDisplayName())));
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        teleportToSpawn(event.getPlayer());
    }

    private void teleportToSpawn(Player player) {
        if (LocationUtil.parseToLocation(config.getString("location.spawn")) != null
                && config.getString("location.spawn") != null) {
            player.teleport(LocationUtil.parseToLocation(config.getString("location.spawn")));
        }
    }
}
