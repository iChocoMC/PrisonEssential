package me.ichoco.prison;

import me.ichoco.prison.listeners.BlockBreakListener;
import me.ichoco.prison.listeners.PlayerListener;

import me.ichoco.prison.commands.*;

import me.ichoco.prison.utils.MessageUtil;

import org.bukkit.plugin.java.JavaPlugin;

public class PrisonEssentialPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        MessageUtil.log("");
        MessageUtil.log(" &e&lPrisonEssentials");
        MessageUtil.log(" &7By iChocoMC_ &8| &60.9");
        MessageUtil.log("");

        registerCommands();
        registerEvents();
    }

    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new PlayerListener(), this);

        if (!this.getConfig().getBoolean("enable-autopickup")) {
            MessageUtil.log(" &6AutoPickup: &cDisable");
            return;
        }
        
        MessageUtil.log(" &6AutoPickup: &aEnable");
        this.getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
    }

    private void registerCommands() {
        this.getCommand("pereload").setExecutor(new PereloadCommand());
        this.getCommand("setspawn").setExecutor(new SetspawnCommand());
        this.getCommand("spawn").setExecutor(new SpawnCommand());
        this.getCommand("help").setExecutor(new HelpCommand());
        this.getCommand("fly").setExecutor(new FlyCommand());

        MessageUtil.log("");
        MessageUtil.log(" &eConfig: &aReloaded");
        MessageUtil.log("");
    }

    public static PrisonEssentialPlugin getInstance() {
        return JavaPlugin.getPlugin(PrisonEssentialPlugin.class);
    }
}
