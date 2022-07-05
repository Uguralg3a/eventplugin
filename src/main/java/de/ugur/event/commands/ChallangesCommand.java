package de.ugur.event.commands;

import de.ugur.event.Main;
import de.ugur.event.timer.Timer;
import de.ugur.event.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ChallangesCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        Inventory i = Bukkit.createInventory(null, 6 * 9, "Challanges");
        i.setItem(0, new ItemBuilder(Material.COMMAND_BLOCK).setDisplayname("Normal").setLocalizedName("normal").build());
        i.setItem(1, new ItemBuilder(Material.DIAMOND_HELMET).setDisplayname("OneHeart").setLocalizedName("oneheart").build());
        i.setItem(2, new ItemBuilder(Material.IRON_DOOR).setDisplayname("Test").setLocalizedName("test").build());


        player.openInventory(i);
        return false;
    }
}
