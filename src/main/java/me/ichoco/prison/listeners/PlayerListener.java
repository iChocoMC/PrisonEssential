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
        player.sendMessage(MessageUtil.translate(this.config.getString("messages.welcome")));
        event.setJoinMessage(String.valueOf(MessageUtil.translate(this.config.getString("messages.join"))) + player.getDisplayName());
        teleportToSpawn(player);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage(MessageUtil.translate(this.config.getString("messages.quit")) + player.getDisplayName());
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        teleportToSpawn(event.getPlayer());
    }

    private void teleportToSpawn(Player player) {
        if (LocationUtil.parseToLocation(this.config.getString("LOCATION.SPAWN")) != null 
                && this.config.getString("LOCATION.SPAWN") != null) {
            player.teleport(LocationUtil.parseToLocation(this.config.getString("LOCATION.SPAWN")));
        }
    }
}
