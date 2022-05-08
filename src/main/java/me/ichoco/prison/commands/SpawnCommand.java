package me.ichoco.prison.commands;

import me.ichoco.prison.PrisonEssentialPlugin;
import me.ichoco.prison.utils.LocationUtil;
import me.ichoco.prison.utils.MessageUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    private final FileConfiguration config = PrisonEssentialPlugin.getInstance().getConfig();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players");
            return true;
        }

        if (!sender.hasPermission("prison.spawn")) {
            sender.sendMessage(MessageUtil.translate(this.config.getString("messages.no_permission")));
            return true;
        }

        Player player = (Player) sender;

        player.teleport(LocationUtil.parseToLocation(config.getString("LOCATION.SPAWN")));
        player.sendMessage(MessageUtil.translate(config.getString("messages.teleported_to_spawn")));
        return true;
    }
}
