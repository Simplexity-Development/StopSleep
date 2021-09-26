package me.adhdmc.stopsleep;

import org.bukkit.plugin.java.JavaPlugin;

public final class Stopsleep extends JavaPlugin {
    public static Stopsleep plugin;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Events(), this);
        this.getCommand("stopsleep").setExecutor(new Commands());
        this.saveDefaultConfig();
        getConfig().addDefault("Message","&cAin't no rest for the wicked");
        getConfig().addDefault("Explosions", false);
        plugin = this;
    }
}
