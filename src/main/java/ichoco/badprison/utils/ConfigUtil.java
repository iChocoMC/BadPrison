package ichoco.badprison.utils;

import ichoco.badprison.BadPrisonMAIN;
import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigUtil {
    
  private File file;
  private FileConfiguration config;
    
  public ConfigUtil(File location, String name){
    file = new File(location, name);

    if (!file.exists()) {
      BadPrisonMAIN.getInstance().saveResource(name, false);
    }
    config = YamlConfiguration.loadConfiguration(file);
  }

  public File getFile(){
    return this.file;
  }
    
  public FileConfiguration getConfig(){
    return this.config;
  }
}