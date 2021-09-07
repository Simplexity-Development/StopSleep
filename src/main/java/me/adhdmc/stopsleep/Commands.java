package me.adhdmc.stopsleep;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!label.equalsIgnoreCase("stopsleep")) {
            return true;
        }
        if (args.length >= 1) {
            if (args[0].equalsIgnoreCase("reload")) {
                Stopsleep.plugin.reloadConfig();
                sender.sendMessage(ChatColor.RED + "Stopsleep has been reloaded");
                return true;
            }
        }
        return true;
    }
}
