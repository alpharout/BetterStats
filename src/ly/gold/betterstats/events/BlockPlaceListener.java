package ly.gold.betterstats.events;

import ly.gold.betterstats.api.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {
    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        User user = new User(event.getPlayer().getDisplayName());
        user.addPlacedBlock();
    }
}
