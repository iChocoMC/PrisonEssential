package me.ichoco.prison.commands;

import me.ichoco.prison.PrisonEssentialPlugin;
import me.ichoco.prison.utils.MessageUtil;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    private final FileConfiguration config = PrisonEssentialPlugin.getInstance().getConfig();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(MessageUtil.translate("&cOnly players"));
            return true;
        }

        if (!sender.hasPermission("prison.fly")) {
            sender.sendMessage(MessageUtil.translate(config.getString("messages.no_permission").replace(
                "{permission}", "prison.fly")));
            return true;
        }

        Player player = (Player) sender;

        if (!player.getAllowFlight()) {
            player.sendMessage(MessageUtil.translate(config.getString("messages.fly_enable")));
            player.setAllowFlight(!player.getAllowFlight());
            return true;
        }
        
        player.setAllowFlight(!player.getAllowFlight());
        player.sendMessage(MessageUtil.translate(config.getString("messages.fly_disable")));
        return true;
    }
}
