package ly.gold.betterstats.main;

import ly.gold.betterstats.api.Data;
import org.bukkit.plugin.java.JavaPlugin;

public class BetterStats extends JavaPlugin {
    private static BetterStats plugin;

    @Override
    public void onEnable() {
        plugin = this;

        Data.log("§7BetterStats is started!");

        this.getConfig().addDefault("mysql.hostname", "localhost");
        this.getConfig().addDefault("mysql.database", "testbase");
        this.getConfig().addDefault("mysql.username", "admin");
        this.getConfig().addDefault("mysql.password", "verysecretpassword");
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
    }

    @Override
    public void onDisable() {
        Data.log("§7BetterStats is stopped!");
    }

    public static BetterStats getInstance() {
        return plugin;
    }
}
