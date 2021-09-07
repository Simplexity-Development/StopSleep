package me.adhdmc.stopsleep;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class Events implements Listener {

    @EventHandler
    public void onBedEnter(PlayerBedEnterEvent event){
        Player player = event.getPlayer();
        if (player.hasPermission("stopsleep.bypass"))
            return;
        event.setCancelled(true);
        if (player.hasPermission("stopsleep.silent"))
            return;
        player.sendMessage(ChatColor.translateAlternateColorCodes('&',Stopsleep.plugin.getConfig().getString("2")));
    }
}
