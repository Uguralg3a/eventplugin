package de.ugur.event.commands;

import de.ugur.event.Main;
import de.ugur.event.timer.Timer;
import de.ugur.event.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class AdminCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        Inventory i = Bukkit.createInventory(null, 6 * 9, "Admin");
        i.setItem(0, new ItemBuilder(Material.COMMAND_BLOCK).setDisplayname("TeleportAll").setLocalizedName("teleportall").build());
        i.setItem(1, new ItemBuilder(Material.BEDROCK).setDisplayname("Gamemode 0").setLocalizedName("gamemodezero").build());
        i.setItem(2, new ItemBuilder(Material.BEDROCK).setDisplayname("Gamemode 1").setLocalizedName("gamemodeone").build());
        i.setItem(3, new ItemBuilder(Material.BEDROCK).setDisplayname("Gamemode 2").setLocalizedName("gamemodetwo").build());
        i.setItem(4, new ItemBuilder(Material.BEDROCK).setDisplayname("Gamemode 3").setLocalizedName("gamemodethree").build());
        player.openInventory(i);
        return false;
    }
}
