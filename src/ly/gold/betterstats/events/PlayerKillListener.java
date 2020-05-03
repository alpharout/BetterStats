package ly.gold.betterstats.events;

import ly.gold.betterstats.api.Data;
import ly.gold.betterstats.api.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerKillListener implements Listener {
    @EventHandler
    public void onKill(PlayerDeathEvent event) {
        User user = new User(event.getEntity().getKiller().getDisplayName());
        user.addPlayerKill();

        event.getEntity().getKiller().sendMessage("Du hast " + user.getPlayerKills() + " Spieler getötet!");
    }
}
