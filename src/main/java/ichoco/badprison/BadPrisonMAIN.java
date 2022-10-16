package ichoco.badprison;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import ichoco.badprison.listener.BlockBreak;
import ichoco.badprison.listener.PlayerInteract;

import ichoco.badprison.menus.PickaxeMenu;
import ichoco.badprison.menus.listeners.InventoryListener;
import ichoco.badprison.utils.ConfigUtil;

import net.milkbowl.vault.economy.Economy;

public class BadPrisonMAIN extends JavaPlugin {
    private static Economy econ;
    private static FileConfiguration messagesConfig;
    private static Inventory PickaxeMenu;

    public static BadPrisonMAIN getInstance() {
        return getPlugin(BadPrisonMAIN.class);
    }

    @Override
    public void onEnable() {
        createConfigs(this.getDataFolder());
        System.out.print(getMessages());
        buildMenus();
        setupEconomy();

        this.getServer().getPluginManager().registerEvents(new InventoryListener(), this); 
        this.getServer().getPluginManager().registerEvents(new PlayerInteract(), this); 
        this.getServer().getPluginManager().registerEvents(new BlockBreak(), this); 
    }

    // Menu System
    public void buildMenus(){
        PickaxeMenu = new PickaxeMenu().getInventory();
    }

    //Config System
    private void createConfigs(File folder){
        if (!folder.exists()){
            folder.mkdirs();
        }
        ConfigUtil message = new ConfigUtil(folder, "messages.yml");
        messagesConfig = message.getConfig();
    }

    public FileConfiguration getMessages(){
        return messagesConfig;
    }

    //Economy System
    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }

        econ = rsp.getProvider();
        return econ != null;
    }

    public static Economy getEconomy() {
        return econ;
    }

    public static Inventory getPickaxeInventory(){
        return PickaxeMenu;
    }
}
