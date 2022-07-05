package de.ugur.event.challanges;

import de.ugur.event.Main;
import de.ugur.event.timer.Timer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Normal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Timer timer = Main.getInstance().getTimer();
        Player player = (Player) sender;

        if (player.isOp()) {
            for (Player op : Bukkit.getOnlinePlayers()) {
                op.setMaxHealth(20);
                op.addPotionEffect(PotionEffectType.REGENERATION.createEffect(10, 5));
                timer.setRunning(false);
                timer.setTime(0);
                op.sendMessage(ChatColor.RED + "Die Challanges wurden zurückgesetzt");
            }
        }
        return false;
    }
}
