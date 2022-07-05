package de.ugur.event.tabCompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class ChallangesTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            List<String> challanges = new ArrayList<>();
            challanges.add("einherzchallange");
            challanges.add("test");
            challanges.add("reset");
            challanges.add("normal");
            return challanges;
        }

        return null;
    }
}
