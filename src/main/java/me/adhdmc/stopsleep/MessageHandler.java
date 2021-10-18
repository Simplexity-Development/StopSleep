package me.adhdmc.stopsleep;

import org.bukkit.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageHandler {
    private static final Pattern hexPattern = Pattern.compile("(&#[a-fA-F0-9]{6})");

    public static String prefix;
    public static String noSleep;
    public static String noPermission;
    public static String noCommand;

    public static String colorParse(String s) {
        Matcher matcher = hexPattern.matcher(s);
        while (matcher.find()) {
            String colorReplace = s.substring(matcher.start(), matcher.end());
            String colorHex = s.substring(matcher.start() + 1, matcher.end());
            s = s.replace(colorReplace, "" + net.md_5.bungee.api.ChatColor.of(colorHex));
            matcher = hexPattern.matcher(s);
        }
        s = ChatColor.translateAlternateColorCodes('&', s);
        return s;
    }
    public static void loadConfigMsgs(){
        prefix = colorParse(Stopsleep.plugin.getConfig().getString("Prefix"));
        noSleep = colorParse(Stopsleep.plugin.getConfig().getString("Message"));
        noPermission = colorParse(Stopsleep.plugin.getConfig().getString("No Permission"));
        noCommand = colorParse(Stopsleep.plugin.getConfig().getString("No Command"));
    }
}
