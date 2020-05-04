package ly.gold.betterstats.events;

import ly.gold.betterstats.api.Data;
import ly.gold.betterstats.api.Stats;
import ly.gold.betterstats.api.User;
import ly.gold.betterstats.main.BetterStats;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class StatsUpdateEvent {
    public static void updatePlayerStats() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(BetterStats.getInstance(), new Runnable() {
            @Override
            public void run() {
                for(Player player : Bukkit.getOnlinePlayers()) {
                    User user = new User(player.getDisplayName());
                    Stats.updateStat(user);


                }

                Data.log("Stats updated!");
            }
        }, 20*60, 20*60);
    }
}
