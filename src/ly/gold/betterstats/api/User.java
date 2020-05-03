package ly.gold.betterstats.api;

import ly.gold.betterstats.main.BetterStats;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.IOException;

public class User {
    private Player player;
    private String name;

    private int placedBlocks;
    private int breakedBlocks;
    private int playerKills;

    public User(String name) {
        this.name = name;
        this.player = (Player) Bukkit.getOfflinePlayer(name);

        this.placedBlocks = BetterStats.getPlayerData().getInt(name + ".placedBlocks");
        this.breakedBlocks = BetterStats.getPlayerData().getInt(name + ".breakedBlocks");
        this.playerKills = BetterStats.getPlayerData().getInt(name + ".playerKills");
    }

    public int getPlacedBlocks() {
        return placedBlocks;
    }

    public int getBreakedBlocks() {
        return breakedBlocks;
    }

    public int getPlayerKills() {
        return playerKills;
    }

    public void addPlacedBlock() {
        BetterStats.getPlayerData().set(name + ".placedBlocks", placedBlocks + 1);
        try {
            BetterStats.getPlayerData().save(BetterStats.getPlayerDataConfig());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addBreakedBlock() {
        BetterStats.getPlayerData().set(name + ".breakedBlocks", breakedBlocks + 1);
        try {
            BetterStats.getPlayerData().save(BetterStats.getPlayerDataConfig());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addPlayerKill() {
        BetterStats.getPlayerData().set(name + ".playerKills", playerKills + 1);
        try {
            BetterStats.getPlayerData().save(BetterStats.getPlayerDataConfig());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
