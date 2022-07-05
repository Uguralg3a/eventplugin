package de.ugur.event.admin;

import org.bukkit.command.CommandExecutor;
import de.ugur.event.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCommand implements CommandExecutor {
    private final Main plugin;


    public VanishCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return false;
        }
        Player p = (Player) sender;

        if (plugin.invisible_list.contains(p)) {
            for (Player people : Bukkit.getOnlinePlayers()) {
                people.showPlayer(plugin, p);
            }
            plugin.invisible_list.remove(p);
            p.sendMessage(Main.prefix + "" + ChatColor.RED + "Du bist nun für alle Spieler sichtbar!");
        } else if (!plugin.invisible_list.contains(p)) {
            for (Player people : Bukkit.getOnlinePlayers()) {
                people.hidePlayer(plugin, p);
            }
            plugin.invisible_list.add(p);
            p.sendMessage(Main.prefix + "" + ChatColor.GREEN + "Du bist nun für alle Spieler unsichtbar!");
        }

        return false;
    }
}
