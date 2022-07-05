package de.ugur.event.timer;

import de.ugur.event.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer {

    private boolean running; //true or false
    private int time;

    private int hours;

    private int minutes;

    private int seconds;

    private int totalSeconds;

    private String timeString;

    public Timer(boolean running, int time) {
        this.running = running;
        this.time = time;


        run();
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
    public void sendActionsBar() {

        for (Player player : Bukkit.getOnlinePlayers()) {

            if (!isRunning()) {
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + "Timer ist Pausiert"));
                continue;
            }

            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD.toString() + ChatColor.BOLD + timeString));
        }
    }

    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {


                sendActionsBar();

                if (!isRunning()) {
                    return;
                }

                hours =  time / 3600;
                minutes = (time % 3600) / 60;
                seconds = time % 60;

                timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);

                setTime(getTime() + 1);

            }
        }.runTaskTimer(Main.getInstance(), 20, 20);
    }
}
