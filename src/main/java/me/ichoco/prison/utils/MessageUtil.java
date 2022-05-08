package me.ichoco.prison.utils;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

@UtilityClass
public class MessageUtil {

    public static String translate(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static List<String> translate(List<String> messages) {
        List<String> buffered = new ArrayList<>();
        messages.forEach(message -> buffered.add(translate(message)));
        return buffered;
    }

    public static void log(String message) {
        Bukkit.getConsoleSender().sendMessage(translate(message));
    }
}
