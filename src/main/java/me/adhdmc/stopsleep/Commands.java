package me.adhdmc.stopsleep;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("StopSleep by Illogical");
            return true;
        }
        if (args[0].equalsIgnoreCase("reload")) {
            Stopsleep.plugin.reloadConfig();
            sender.sendMessage(ChatColor.RED + "Stopsleep has been reloaded");
        } else {
            sender.sendMessage(ChatColor.RED + "No subcommand by that name");
        }
        return true;

    }

}
