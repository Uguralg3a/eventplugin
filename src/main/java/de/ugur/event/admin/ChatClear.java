package de.ugur.event.admin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatClear implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if (player.isOp()) {
            for (int i = 0; i <= 300; i++) {
                Bukkit.broadcastMessage(" ");
            }
            Bukkit.broadcastMessage(ChatColor.GREEN + "Der Spieler " + ChatColor.BOLD + ChatColor.GOLD + player.getName() + ChatColor.RESET + ChatColor.GREEN + " geleert!");
        } else {
            return false;
        }

        return false;
    }
}
