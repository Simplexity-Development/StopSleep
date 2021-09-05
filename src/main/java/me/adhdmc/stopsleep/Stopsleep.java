package me.adhdmc.stopsleep;

import org.bukkit.plugin.java.JavaPlugin;

public final class Stopsleep extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Stop Sleep is starting");
        getServer().getPluginManager().registerEvents(new Events(), this);
    }
}
