package me.adhdmc.stopsleep;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;


public final class Stopsleep extends JavaPlugin {
    FileConfiguration config = getConfig();
    public static Stopsleep plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Stop Sleep is starting");
        getServer().getPluginManager().registerEvents(new Events(), this);
        this.getCommand("stopsleep").setExecutor(new Commands());
        this.saveDefaultConfig();
        this.getConfig();
        config.addDefault("Message","&cAin't no rest for the wicked");
        plugin = this;
    }
}
