package org.idroom;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;

public class PlateouPluginHide extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onCommandPreProcess(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage().toLowerCase();

        if (message.equals("/pl") || message.equals("/plugins")) {
            if (!player.hasPermission("plateoupluginhide.view")) {
                event.setCancelled(true);
                player.sendMessage("§cYou do not have permission to view plugins.");
            }
        }
    }
}
