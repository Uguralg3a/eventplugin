package de.ugur.event.listeners;

import de.ugur.event.Main;
import de.ugur.event.timer.Timer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class MainListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        String joinMessage = Main.prefix + ChatColor.GOLD + player.getName() + ChatColor.GREEN + " hat den Server betreten!";
        player.setGameMode(GameMode.SURVIVAL);

        event.setJoinMessage(joinMessage);

        if(player.isOp()){
            player.setPlayerListName(ChatColor.BLUE + "[TEAM]" + ChatColor.RESET + " " + player.getName());
        }else {
            player.setPlayerListName(ChatColor.GRAY + "[SPIELER]" + ChatColor.RESET + " " + player.getName());
        }

    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        String quitMessage = Main.prefix + ChatColor.GOLD + player.getName() + ChatColor.RED + " hat den Server verlassen!";

        event.setQuitMessage(quitMessage);
    }

    @EventHandler
    public void onChatMessageRank(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if(player.isOp()){
            event.setFormat(ChatColor.BLUE + "[TEAM]" + ChatColor.RESET + " " + player.getName() + " : " + event.getMessage());
        }else {
            event.setFormat(ChatColor.GRAY + "[SPIELER]" + ChatColor.RESET + " " + player.getName() + " : " + event.getMessage());
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Timer timer = Main.getInstance().getTimer();
        Player player = event.getPlayer();
        if (!timer.isRunning()) {
            event.setCancelled(true);
            player.sendMessage(Main.prefix + ChatColor.RED + "Der Timer muss aktiviert sein, um etwas zu bauen!");
        } else {
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockDamageEvent event) {
        Timer timer = Main.getInstance().getTimer();
        Player player = event.getPlayer();
        if (!timer.isRunning()) {
            event.setCancelled(true);
            player.sendMessage(Main.prefix + ChatColor.RED + "Der Timer muss aktiviert sein, um etwas abzubauen!");
        } else {
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onPlayerToEntityDamage(EntityDamageByEntityEvent event) {
        Timer timer = Main.getInstance().getTimer();

        if (!timer.isRunning()) {
            event.setCancelled(true);
        } else {
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onAdminInvClick(InventoryClickEvent e) {
        if (e.getCurrentItem() == null) return;
        if (e.getView().getTitle().equalsIgnoreCase("Admin")) {
            Player p = (Player) e.getWhoClicked();
            e.setCancelled(true);
            System.out.println("Der Admin Listener funktioniert");
            if (e.getCurrentItem().getItemMeta().hasLocalizedName()) {
                switch (e.getCurrentItem().getItemMeta().getLocalizedName()) {
                    case "teleportall": {
                        p.performCommand("teleportall");
                        p.closeInventory();
                        break;
                    }
                    case "gamemodezero": {
                        p.performCommand("gm 0");
                        p.closeInventory();
                        break;
                    }
                    case "gamemodeone": {
                        p.performCommand("gm 1");
                        p.closeInventory();
                        break;
                    }
                    case "gamemodetwo": {
                        p.performCommand("gm 2");
                        p.closeInventory();
                        break;
                    }
                    case "gamemodethree": {
                        p.performCommand("gm 3");
                        p.closeInventory();
                        break;
                    }
                }
            }
        }
    }

    @EventHandler
    public void onChallangeInvClick(InventoryClickEvent e) {
        if (e.getCurrentItem() == null) return;
        if (e.getView().getTitle().equalsIgnoreCase("Challanges")) {
            System.out.println("Der Challanges Listener funktioniert");
            Player p = (Player) e.getWhoClicked();
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().hasLocalizedName()) {
                switch (e.getCurrentItem().getItemMeta().getLocalizedName()) {
                        case "normal": {
                            p.performCommand("normal");
                            p.closeInventory();
                            break;
                        }
                    case "oneheart": {
                        p.performCommand("oneheart");
                        p.closeInventory();
                        break;
                    }
                    case "test": {
                        p.performCommand("test");
                        p.closeInventory();
                        break;
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerDeathStopTimer(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();
        Timer timer = Main.getInstance().getTimer();

        if (player.isDead()) {
            for (Player op : Bukkit.getOnlinePlayers()) {
                op.setGameMode(GameMode.SPECTATOR);
                timer.setRunning(false);
                timer.setTime(0);
                op.sendMessage(Main.prefix + "Die Challange wurde beendet");
                op.sendMessage(player.getName() + " ist gestorben!");
            }
        }
    }
}