package de.ugur.event.challanges;

import de.ugur.event.Main;
import de.ugur.event.timer.Timer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OneHeartChallange implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Timer timer = Main.getInstance().getTimer();
        Player player = (Player) sender;
        if (player.isOp()) {
            timer.setRunning(true);
            for (Player op : Bukkit.getOnlinePlayers()) {
                World world = op.getWorld();
                op.sendMessage(Main.prefix + ChatColor.RED + "Die EINHERZ Challange wurde gestartet!");
                op.setMaxHealth(1);
                op.teleport(world.getSpawnLocation());
            }
        }
        return false;
    }
}
