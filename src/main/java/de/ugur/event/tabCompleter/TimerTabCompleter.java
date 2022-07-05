package de.ugur.event.tabCompleter;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.BaseStream;

public class TimerTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 1) {
            List<String> timer = new ArrayList<>();
            timer.add("start");
            timer.add("resume");
            timer.add("stop");
            timer.add("pause");
            timer.add("reset");
            timer.add("time");

            return timer;
        }
        return null;
    }
}
