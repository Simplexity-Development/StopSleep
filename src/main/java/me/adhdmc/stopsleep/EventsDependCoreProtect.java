package me.adhdmc.stopsleep;

import net.coreprotect.CoreProtect;
import net.coreprotect.CoreProtectAPI;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.plugin.Plugin;

import static org.bukkit.Bukkit.getServer;


public class EventsDependCoreProtect implements Listener {
    CoreProtectAPI api = getCoreProtect();
    private CoreProtectAPI getCoreProtect() {
        Plugin plugin = getServer().getPluginManager().getPlugin("CoreProtect");

        // Check that CoreProtect is loaded
        if (!(plugin instanceof CoreProtect)) {
            return null;
        }

        // Check that the API is enabled
        CoreProtectAPI CoreProtect = ((CoreProtect) plugin).getAPI();
        if (!CoreProtect.isEnabled()) {
            return null;
        }

        // Check that a compatible version of the API is loaded
        if (CoreProtect.APIVersion() < 7) {
            return null;
        }

        return CoreProtect;
    }

    @EventHandler
    public void onBedInteract(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("stopsleep.bypass")) return;
        event.setCancelled(true);
        if (Stopsleep.plugin.getConfig().getBoolean("Break Bed", true)) {
            if (api.isEnabled()) {
                api.logRemoval(player.getName(), event.getBed().getLocation(), event.getBed().getType(), null);
            }
            event.getBed().breakNaturally();
        }
        if (Stopsleep.plugin.getConfig().getBoolean("Explosions", true)) {
            Location location = event.getBed().getLocation();
            player.getWorld().createExplosion(location, Stopsleep.plugin.getConfig().getInt("Explosion Power", 1), Stopsleep.plugin.getConfig().getBoolean("Explosion Fire", false), Stopsleep.plugin.getConfig().getBoolean("Explosion Block Damage", false));
        }
        if (player.hasPermission("stopsleep.silent")) return;
        if (player.getWorld().getTime() > 12542) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', Stopsleep.plugin.getConfig().getString("Message", "&cAin't no rest for the wicked")));
        }
    }
}