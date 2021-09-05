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
        if (!player.hasPermission("stopsleep.bypass"))
        {
            if (!player.hasPermission("stopsleep.silent"))
            {
                player.sendMessage(ChatColor.RED+"Ain't no rest for the wicked");
            }
            event.setCancelled(true);
        }
    }
    public void setSpawn(){}

}
