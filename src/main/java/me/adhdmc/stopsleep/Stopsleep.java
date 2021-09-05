package me.adhdmc.stopsleep;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Stopsleep extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Stop Sleep is starting");
        getServer().getPluginManager().registerEvents(new Events(), this);
    }
}
