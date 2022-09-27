package ichoco.badprison.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

public class MessageUtil {
    
    public static String translate(String lore){
        return ChatColor.translateAlternateColorCodes('&', lore);
    }

    public static List<String> translateStrings(List<String> messages) {
        List<String> buffered = new ArrayList<String>();
        messages.forEach((message) -> buffered.add(MessageUtil.translate(message)));
        return buffered;
    }
}
