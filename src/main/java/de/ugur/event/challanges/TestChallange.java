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

public class TestChallange implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Timer timer = Main.getInstance().getTimer();
        Player player = (Player) sender;

        if (sender.isOp()) {
            timer.setRunning(true);
            for (Player op : Bukkit.getOnlinePlayers()) { //op = online players
                World world = op.getWorld();
                op.sendMessage(ChatColor.RED + "Das ist die Test Challange!");
                op.teleport(world.getSpawnLocation());
                if (op.isDead()) {
                    timer.setRunning(false);
                    op.sendMessage(Main.prefix + ChatColor.GOLD + player.getName() + ChatColor.RED + "ist gestorben!");
                }
            }
        }
        return false;
    }
}
