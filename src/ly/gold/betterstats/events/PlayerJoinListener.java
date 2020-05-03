package ly.gold.betterstats.events;

import ly.gold.betterstats.api.Stats;
import ly.gold.betterstats.api.User;
import ly.gold.betterstats.main.BetterStats;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        FileConfiguration playerData = BetterStats.getPlayerData();

        if(!playerData.getBoolean(event.getPlayer().getDisplayName() + ".hasAccount")) {
            Stats.createStatPlayer(new User(event.getPlayer().getDisplayName()));
        }

        playerData.addDefault(event.getPlayer().getDisplayName() + ".hasAccount", true);
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
