package ly.gold.betterstats.events;

import ly.gold.betterstats.main.BetterStats;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        FileConfiguration playerData = BetterStats.getPlayerData();

        playerData.addDefault(event.getPlayer().getDisplayName() + ".placedBlocks", 0);
        playerData.addDefault(event.getPlayer().getDisplayName() + ".breakedBlocks", 0);
        playerData.addDefault(event.getPlayer().getDisplayName() + ".playerKills", 0);
        playerData.options().copyDefaults(true);
        try {
            playerData.save(BetterStats.getPlayerDataConfig());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
