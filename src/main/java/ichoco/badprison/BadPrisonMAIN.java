package ichoco.badprison;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import ichoco.badprison.commands.EnchantItemCMD;
import ichoco.badprison.enchantments.CustomEnchants;
import ichoco.badprison.listener.BlockBreak;
import ichoco.badprison.listener.PlayerInteract;
import ichoco.badprison.menus.PickaxeMenu;
import ichoco.badprison.menus.listeners.InventoryListener;
import net.milkbowl.vault.economy.Economy;

public class BadPrisonMAIN extends JavaPlugin {
    private static Economy econ;
    
    @Override
    public void onEnable() {
        buildMenus();
        setupEconomy();
        saveDefaultConfig();
        
        CustomEnchants.register();

        this.getCommand("benchant").setExecutor(new EnchantItemCMD());

        this.getServer().getPluginManager().registerEvents(new InventoryListener(), this); 
        this.getServer().getPluginManager().registerEvents(new PlayerInteract(), this); 
        this.getServer().getPluginManager().registerEvents(new BlockBreak(), this); 
    }

    public void buildMenus(){
        new PickaxeMenu();
    }

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

    public static BadPrisonMAIN getInstance() {
        return getPlugin(BadPrisonMAIN.class);
    }
}
