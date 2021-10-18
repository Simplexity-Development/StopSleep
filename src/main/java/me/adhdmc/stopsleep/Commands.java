package me.adhdmc.stopsleep;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
        sender.sendMessage(MessageHandler.prefix + ChatColor.GREEN + "StopSleep by IllogicalSong");
            return true;
        }
        if (args[0].equalsIgnoreCase("reload")) {
            if(sender instanceof Player && !sender.hasPermission("stopsleep.reload")){
                sender.sendMessage(MessageHandler.noPermission);
                return true;
            }
            Stopsleep.plugin.reloadConfig();
            MessageHandler.loadConfigMsgs();
            sender.sendMessage(ChatColor.GOLD + "Stopsleep has been reloaded");
        } else {
            sender.sendMessage(MessageHandler.prefix + MessageHandler.noCommand);
        }
        return true;

    }

}
