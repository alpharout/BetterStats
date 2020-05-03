package ly.gold.betterstats.main;

import de.craftagain.betterstats.mysql.MySQL;
import ly.gold.betterstats.api.Data;
import ly.gold.betterstats.events.BlockBreakListener;
import ly.gold.betterstats.events.BlockPlaceListener;
import ly.gold.betterstats.events.PlayerJoinListener;
import ly.gold.betterstats.events.PlayerKillListener;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BetterStats extends JavaPlugin {
    private static BetterStats plugin;
    private static File playerDataConfig;
    private static FileConfiguration playerData;

    @Override
    public void onEnable() {
        plugin = this;
        MySQL.connect();
        Data.log("§7BetterStats is started!");

        // custom config setup
        setupPlayerDataConfig();

        // normal config setup
        this.getConfig().addDefault("mysql.hostname", "localhost");
        this.getConfig().addDefault("mysql.database", "testbase");
        this.getConfig().addDefault("mysql.username", "admin");
        this.getConfig().addDefault("mysql.password", "verysecretpassword");
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();

        PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.registerEvents(new PlayerKillListener(), this);
        pluginManager.registerEvents(new PlayerJoinListener(), this);
        pluginManager.registerEvents(new BlockBreakListener(), this);
        pluginManager.registerEvents(new BlockPlaceListener(), this);
    }

    @Override
    public void onDisable() {
        Data.log("§7BetterStats is stopped!");
        MySQL.disconnect();
    }

    public static BetterStats getInstance() {
        return plugin;
    }

    private void setupPlayerDataConfig() {
        // playerDataConfig setup
        playerDataConfig = new File(getDataFolder(), "playerdata.yml");

        if(!playerDataConfig.exists()) {
            playerDataConfig.getParentFile().mkdirs();
            saveResource("playerdata.yml", false);
        }

        playerData = new YamlConfiguration();

        try {
            playerData.load(playerDataConfig);
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FileConfiguration getPlayerData() {
        return playerData;
    }

    public static File getPlayerDataConfig() {
        return playerDataConfig;
    }
}
