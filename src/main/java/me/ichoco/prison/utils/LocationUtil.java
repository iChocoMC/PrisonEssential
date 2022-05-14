package me.ichoco.prison.utils;

import lombok.experimental.UtilityClass;

import org.bukkit.Bukkit;
import org.bukkit.Location;

@UtilityClass
public class LocationUtil {

    public static String parseToString(Location location) {
        return (location == null) ? null : location.getX() + ", " + location.getY() + ", " + location.getZ() + ", " + location.getYaw() + ", " + location.getPitch() + ", " + location.getWorld().getName();
    }

    public static Location parseToLocation(String string) {
        if (string == null) {
            return null;
        }
        String[] data = string.split(", ");
        try {

            Location location = new Location(Bukkit.getWorld(data[5]), Double.parseDouble(data[0]),
                    Double.parseDouble(data[1]), Double.parseDouble(data[2]),
                    Float.valueOf(data[3]), Float.valueOf(data[4]));

            return location;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }
}
