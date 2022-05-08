package me.ichoco.prison.commands;

import me.ichoco.prison.PrisonEssentialPlugin;
import me.ichoco.prison.utils.MessageUtil;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HelpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(MessageUtil.translate(PrisonEssentialPlugin
                .getInstance().getConfig().getString("messages.help")));
        return true;
    }
}
