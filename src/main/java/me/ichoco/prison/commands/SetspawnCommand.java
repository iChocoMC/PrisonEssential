package me.ichoco.prison.commands;

import me.ichoco.prison.PrisonEssentialPlugin;
import me.ichoco.prison.utils.LocationUtil;
import me.ichoco.prison.utils.MessageUtil;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SetspawnCommand implements CommandExecutor {

    private final FileConfiguration config = PrisonEssentialPlugin.getInstance().getConfig();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only Players");
            return true;
        }

        if (!sender.hasPermission("prison.setspawn")) {
            sender.sendMessage(MessageUtil.translate(this.config.getString("messages.no_permission")));
            return true;
        }

        Player player = (Player) sender;

        this.config.set("LOCATION.SPAWN", LocationUtil.parseToString(player.getLocation()));
        
        PrisonEssentialPlugin.getInstance().saveConfig();
        player.sendMessage(MessageUtil.translate("&aSpawn has been currently setted."));
        return true;
    }
}
