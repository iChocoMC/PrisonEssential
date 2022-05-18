package me.ichoco.prison.commands;

import me.ichoco.prison.PrisonEssentialPlugin;
import me.ichoco.prison.utils.MessageUtil;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PereloadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("prison.reload")) {
            sender.sendMessage(MessageUtil.translate(PrisonEssentialPlugin.getInstance()
                .getConfig().getString("messages.no_permission").replace("{permission}", "prison.reload")));
            return true;
        }

        PrisonEssentialPlugin.getInstance().reloadConfig();
        PrisonEssentialPlugin.getInstance().onEnable();

        sender.sendMessage("PrisonEssentials reloaded");
        return true;
    }
}
