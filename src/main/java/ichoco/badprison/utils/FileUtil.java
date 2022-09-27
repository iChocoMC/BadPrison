package ichoco.badprison.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import ichoco.badprison.BadPrisonMAIN;

public class FileUtil {

    private static BadPrisonMAIN plugin = BadPrisonMAIN.getInstance();

    private static File file = new File(plugin.getDataFolder(), "sell.yml");
    private static FileConfiguration config = (FileConfiguration)YamlConfiguration.loadConfiguration(file);

    public void startConfigs(){
        if (!plugin.getDataFolder().exists()){
            plugin.getDataFolder().mkdirs();
        }

        if (!file.exists()){
            plugin.saveResource("sell.yml", false); 
        }
    }

    public static void saveSellConfig() {
        try {
            config.save(file);
        } catch (IOException iOException) {}
    }

    public static FileConfiguration getSellConfig(){
        return config;
    }
}
