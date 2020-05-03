package ly.gold.betterstats.events;

import ly.gold.betterstats.api.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        User user = new User(event.getPlayer().getDisplayName());
        user.addBreakedBlock();
    }
}
