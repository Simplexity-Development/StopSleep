package me.adhdmc.stopsleep;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;


public class Events implements Listener {

    @EventHandler
    public void onBedInteract(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("stopsleep.bypass")) {
            return;
        }
        event.setCancelled(true);
        if (Stopsleep.plugin.getConfig().getBoolean("Break Bed", true)) {
            event.getBed().breakNaturally();
        }
        if (Stopsleep.plugin.getConfig().getBoolean("Explosions", true)) {
            Location location = event.getBed().getLocation();
            player.getWorld().createExplosion(location,
                    Stopsleep.plugin.getConfig().getInt("Explosion Power", 1),
                    Stopsleep.plugin.getConfig().getBoolean("Explosion Fire", false),
                    Stopsleep.plugin.getConfig().getBoolean("Explosion Block Damage", false));
        }
        if (player.hasPermission("stopsleep.silent")) {
            return;
        }
        if (player.getWorld().getTime() > 12542) {
            player.sendMessage(MessageHandler.noSleep);
        }
    }
}