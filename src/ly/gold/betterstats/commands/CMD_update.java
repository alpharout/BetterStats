package ly.gold.betterstats.commands;

import ly.gold.betterstats.api.Data;
import ly.gold.betterstats.api.Stats;
import ly.gold.betterstats.api.User;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import javax.jws.soap.SOAPBinding;

public class CMD_update implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;
            User user = new User(player.getDisplayName());

            Stats.updateStat(user);
            player.sendMessage(Data.getPrefix() + "§7Deine §6Stats§7 wurden §6geupdated§7!");
        }
        return false;
    }
}
