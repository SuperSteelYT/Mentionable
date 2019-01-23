package me.superischroma.mentionable;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Mentionable extends JavaPlugin implements Listener
{
    @Override
    public void onEnable()
    {
        Bukkit.getPluginManager().registerEvents(this, this);
        this.getLogger().info("Enabled.");
    }

    @Override
    public void onDisable()
    {
        this.getLogger().info("Disabled.");
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e)
    {
        String message = e.getMessage();
        for (Player player : Bukkit.getOnlinePlayers())
        {
            if (message.contains("@" + player.getName()))
            {
                message = message.replace("@" + player.getName(), ChatColor.LIGHT_PURPLE + "@" + player.getName() + ChatColor.RESET);
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 4F, 1F);
                e.setMessage(message);
            }
        }
    }
}
