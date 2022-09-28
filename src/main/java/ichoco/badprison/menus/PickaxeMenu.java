package ichoco.badprison.menus;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import ichoco.badprison.BadPrisonMAIN;
import ichoco.badprison.utils.MessageUtil;

public class PickaxeMenu implements Listener {

    private static Inventory INV;
    private List<String> lore = BadPrisonMAIN.getInstance().getConfig().getStringList("custom-lore");
    private List<String> lore_detailed = BadPrisonMAIN.getInstance().getConfig().getStringList("detailed-explanation");
    
    public PickaxeMenu() {
        INV = Bukkit.createInventory(null, 27, "1 Nivel = 1% | Encanta tu pico");
        
        slot(3, Material.EMERALD_BLOCK, "&a&lSUERTE", lore, "&fSegún el dinero ganado, se multiplicara");
        slot(4, Material.STONE, "&7&lCUBO", lore, "&fCrea un cuadrado &e7x7");
        slot(5, Material.REDSTONE, "&c&lLASER", lore, "&fQuita una &6capa entera&f de la mina");
        
        slot(26, Material.BOOK, "&9&lExplicación detallada", lore_detailed, "");
    }

    public void slot(int slot, Material material, String name, List<String> lore, String description){
        List<String> buffered = new ArrayList<String>();
        buffered.add(MessageUtil.translate(description));
        lore.forEach((message) -> buffered.add(MessageUtil.translate(message)));

        ItemStack item = new ItemBuilder(material)
            .setName(MessageUtil.translate(name))
            .setLore(buffered)
            .toItemStack();

        INV.setItem(slot, item);
    }

    public static Inventory getInventory(){
        return INV;
    }
}