package de.ugur.event.admin;

import de.ugur.event.Main;
import de.ugur.event.timer.Timer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportAll implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Timer timer = Main.getInstance().getTimer();
        Player player = (Player) sender;

        for (Player op : Bukkit.getOnlinePlayers()) {
            timer.setRunning(false);
            timer.setTime(0);
            op.teleport(((Player) sender).getLocation());
            op.sendMessage(ChatColor.GRAY + "Alle wurden zu " + ChatColor.GOLD + player.getName() + " teleportiert.");
        }

        return false;
    }
}
