package ichoco.badprison.utils;

import org.bukkit.configuration.file.FileConfiguration;

import ichoco.badprison.BadPrisonMAIN;

public class MessageUtil {
    public static FileConfiguration config = BadPrisonMAIN.getInstance().getMessages();

    public static String Enchantment_Format = config.getString("enchantment-format".replace('&', '§'));
    
    //Get the stringlist and transform to string using for loop
    public static String transformToString(String section){
        String string = "";
        for(String line : config.getStringList(section)){
            string += line + "\n";
        }
        return string.replace('&', '§');
    }
}
