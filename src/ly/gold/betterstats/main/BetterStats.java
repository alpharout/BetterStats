package ly.gold.betterstats.main;

import ly.gold.betterstats.api.Data;
import org.bukkit.plugin.java.JavaPlugin;

public class BetterStats extends JavaPlugin {
    @Override
    public void onEnable() {
        Data.log("§7BetterStats is started!");
    }

    @Override
    public void onDisable() {
        Data.log("§7BetterStats is stopped!");
    }
}
