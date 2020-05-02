package ly.gold.betterstats.api;

import org.bukkit.Bukkit;

public class Data {
    private static String name = "BetterStats";
    private static String prefix = "[" + name + "] ";

    public static String getPrefix() {
        return prefix;
    }

    public static String getName() {
        return name;
    }

    public static void log(String msg) {
        Bukkit.getConsoleSender().sendMessage(prefix + msg);
    }
}
