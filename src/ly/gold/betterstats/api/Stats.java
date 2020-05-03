package ly.gold.betterstats.api;

import de.craftagain.betterstats.mysql.MySQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Stats {
    static Connection connection = MySQL.getCon();

    public static void updateStat(User user) {
        try {
            Statement statement = connection.createStatement();

            statement.executeUpdate("UPDATE stats SET brokenblocks = '" + user.getBreakedBlocks() + "', placedblocks = '" + user.getPlacedBlocks() + "', playerkills = '" + user.getPlayerKills() + "' WHERE player = '" + user.getOfflinePlayer().getName() + "'");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public static void createStatPlayer(User user) {
        try {
            Statement statement = connection.createStatement();

            statement.executeUpdate("INSERT INTO stats (player, brokenblocks, placedblocks, playerkills) VALUES ('" + user.getOfflinePlayer().getName() + "', '" + user.getBreakedBlocks() + "', '" + user.getPlacedBlocks() + "', '" + user.getPlayerKills() + "')");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }
}
