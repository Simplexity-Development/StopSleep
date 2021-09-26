package me.adhdmc.stopsleep;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class Events implements Listener {

    @EventHandler
    public void onBedInteract(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("stopsleep.bypass")) return;
        event.setCancelled(true);
        if (Stopsleep.plugin.getConfig().getBoolean("Explosions", true)) {
            Location location = event.getPlayer().getLocation();
            player.getWorld().createExplosion(location, 1, false, false);
        }
        if (player.hasPermission("stopsleep.silent")) return;
        if (player.getWorld().getTime() > 12542) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', Stopsleep.plugin.getConfig().getString("Message", "&cAin't no rest for the wicked")));
        }
    }
}
