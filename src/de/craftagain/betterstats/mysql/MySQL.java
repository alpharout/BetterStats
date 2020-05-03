package de.craftagain.betterstats.mysql;

import ly.gold.betterstats.api.Data;
import ly.gold.betterstats.main.BetterStats;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    private static String host;
    private static String port;
    private static String database;
    private static String username;
    private static String password;

    //Connection
    private static Connection con;

    public static void connect(){
        if(!isConnected()){
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
                Data.log("Succesfully connected to Database");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else
            Data.log("Already connected to Database");
    }
    public static void disconnect() {
            if(isConnected()){
                try {
                    con.close();
                    Data.log("Successfully disconnected from database");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else
                Data.log("There is no active connection");
    }
    public static boolean isConnected(){
        return con != null;
    }

    public static Connection getCon() {
        return con;
    }
}
