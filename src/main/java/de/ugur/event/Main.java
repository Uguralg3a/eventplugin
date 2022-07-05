package de.ugur.event;


import de.ugur.event.admin.ChatClear;
import de.ugur.event.admin.TeleportAll;
import de.ugur.event.challanges.Normal;
import de.ugur.event.challanges.OneHeartChallange;
import de.ugur.event.challanges.TestChallange;
import de.ugur.event.commands.AdminCommand;
import de.ugur.event.commands.ChallangesCommand;
import de.ugur.event.admin.GamemodeCommand;
import de.ugur.event.commands.TimerCommand;
import de.ugur.event.listeners.MainListener;
import de.ugur.event.recipes.CraftingRecipes;
import de.ugur.event.tabCompleter.ChallangesTabCompleter;
import de.ugur.event.tabCompleter.GamemodeTabCompleter;
import de.ugur.event.tabCompleter.TimerTabCompleter;
import de.ugur.event.timer.Timer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;


public final class Main extends JavaPlugin {

    public ArrayList<Player> invisible_list = new ArrayList<>();

    public static String prefix = ChatColor.BLUE + "Challanges >> " + ChatColor.RESET;
    private static Main instance;

    private Timer timer;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {

        System.out.println(prefix + "Das Plugin wurde geladen!");

        registerChallanges();
        registerAdmin();
        registerListeners();
        registerCommands();
        registerTabCompleter();
        registerRecipes();

        timer = new Timer(false, 0);
    }

    private void registerRecipes() {
        PluginManager m = Bukkit.getPluginManager();
        m.registerEvents(new CraftingRecipes(this), this);
    }

    private void registerTabCompleter() {
        getCommand("timer").setTabCompleter(new TimerTabCompleter());
        getCommand("gamemode").setTabCompleter(new GamemodeTabCompleter());
        getCommand("gm").setTabCompleter(new GamemodeTabCompleter());
        getCommand("challanges").setTabCompleter(new ChallangesTabCompleter());
    }

    private void registerCommands() {
        getCommand("timer").setExecutor(new TimerCommand());
        getCommand("gamemode").setExecutor(new GamemodeCommand());
        getCommand("gm").setExecutor(new GamemodeCommand());
        getCommand("challanges").setExecutor(new ChallangesCommand());
        getCommand("admin").setExecutor(new AdminCommand());
    }

    private void registerListeners() {
        PluginManager m = Bukkit.getPluginManager();
        m.registerEvents(new MainListener(), this);
    }

    private void registerChallanges() {

        getCommand("oneheart").setExecutor(new OneHeartChallange());
        getCommand("test").setExecutor(new TestChallange());
        getCommand("normal").setExecutor(new Normal());
    }

    private void registerAdmin() {
        getCommand("chatclear").setExecutor(new ChatClear());
        getCommand("teleportall").setExecutor(new TeleportAll());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getInstance() {
        return instance;
    }

    public Timer getTimer() {
        return timer;
    }
}
