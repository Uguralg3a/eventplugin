package de.ugur.event.admin;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {
            sendUsage(sender);
            return true;
        }

        Player p = (Player) sender;
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("zero")) {
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage("Dein Gamemode wurde auf Survival gewechselt.");
            }
            if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("one")) {
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage("Dein Gamemode wurde auf Creative gewechselt.");
            }
            if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("two")) {
                p.setGameMode(GameMode.ADVENTURE);
                p.sendMessage("Dein Gamemode wurde auf Adventure gewechselt.");
            }
            if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("three")) {
                p.setGameMode(GameMode.SPECTATOR);
                p.sendMessage("Dein Gamemode wurde auf Spectator gewechselt.");
            }
        }
        if (args.length == 2) {
            if (args[1].equalsIgnoreCase("@a")) {
                if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("zero")) {
                    for (Player pl : Bukkit.getOnlinePlayers()) {
                        pl.setGameMode(GameMode.SURVIVAL);
                        pl.sendMessage("Der Gamemode von allen wurde auf Survival gewechselt.");
                    }
                } else if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("one")) {
                    for (Player pl : Bukkit.getOnlinePlayers()) {
                        pl.setGameMode(GameMode.CREATIVE);
                        pl.sendMessage("Der Gamemode von allen wurde auf Creative gewechselt.");
                    }
                } else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("two")) {
                    for (Player pl : Bukkit.getOnlinePlayers()) {
                        pl.setGameMode(GameMode.ADVENTURE);
                        pl.sendMessage("Der Gamemode von allen wurde auf Adventure gewechselt.");
                    }
                } else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("three")) {
                    for (Player pl : Bukkit.getOnlinePlayers()) {
                        pl.setGameMode(GameMode.SPECTATOR);
                        pl.sendMessage("Der Gamemode von allen wurde auf Spectator gewechselt.");
                    }
                }

            } else {
                try {
                    Player s = Bukkit.getPlayer(args[1]);
                    if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("zero")) {
                        s.setGameMode(GameMode.SURVIVAL);
                        s.sendMessage("Dein Gamemode wurde auf Survival gewechselt.");
                    } else if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("one")) {
                        s.setGameMode(GameMode.CREATIVE);
                        s.sendMessage("Dein Gamemode wurde auf Creative gewechselt.");
                    } else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("two")) {
                        s.setGameMode(GameMode.ADVENTURE);
                        s.sendMessage("Dein Gamemode wurde auf Adventure gewechselt.");
                    } else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("three")) {
                        s.setGameMode(GameMode.SPECTATOR);
                        s.sendMessage("Dein Gamemode wurde auf Spectator gewechselt.");
                    }
                } catch (Exception e) {
                    for (Player pl : Bukkit.getOnlinePlayers()) {
                        pl.sendMessage("Der Spieler §9" + args[0] + " §7 konnte §cnicht gefunden §7werden.");
                    }
                }
            }
        }
        return false;
    }

    private void sendUsage(CommandSender sender) {
        sender.sendMessage("§7Verwendung§8: §9/gamemode 0, /gamemode 1, /gamemode 2, /gamemode 3 §2@a/<Spieler>");
    }

}

