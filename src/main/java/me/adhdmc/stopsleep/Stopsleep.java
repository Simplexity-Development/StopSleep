package me.adhdmc.stopsleep;

import org.bukkit.plugin.java.JavaPlugin;

public final class Stopsleep extends JavaPlugin {
    public static Stopsleep plugin;

    @Override
    public void onEnable() {
        plugin = this;
        if (plugin.getServer().getPluginManager().isPluginEnabled("CoreProtect")){
            plugin.getServer().getPluginManager().registerEvents(new EventsDependCoreProtect(), this);
        }else{
                plugin.getServer().getPluginManager().registerEvents(new Events(), this);}
        this.getCommand("stopsleep").setExecutor(new Commands());
        this.saveDefaultConfig();
        getConfig().addDefault("Prefix", "&#006a7d&l[&#26a5ffStopSleep&#006a7d&l] ");
        getConfig().addDefault("Message","&cAin't no rest for the wicked");
        getConfig().addDefault("No Command", "&cNo subcommand by that name");
        getConfig().addDefault("No Permission", "&cYou do not have permission to run this command");
        getConfig().addDefault("Break Bed", false);
        getConfig().addDefault("Explosions", false);
        getConfig().addDefault("Explosion Fire", false);
        getConfig().addDefault("Explosion Block Damage", false);
        getConfig().addDefault("Explosion Power", 1);
        MessageHandler.loadConfigMsgs();
    }
}
