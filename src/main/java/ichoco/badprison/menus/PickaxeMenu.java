package ichoco.badprison.menus;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import ichoco.badprison.utils.MessageUtil;

public class PickaxeMenu {

    private Inventory INV;

    public PickaxeMenu() {

        String Enchantment_Lore = MessageUtil.transformToString("enchantment-lore");
        String Detailed_Lore = MessageUtil.transformToString("detailed-explanation");
        
        INV = Bukkit.createInventory(
            null,
            9 * 3 , // 9 = rows, 3 = size
            "1 Nivel = 1% | Encanta tu pico"
        );

        slot(26, Material.BOOK, "§9§lExplicación detallada",
            Detailed_Lore, "");

        //Enchantments
        slot(3, Material.EMERALD_BLOCK, "§a§lSUERTE",
            Enchantment_Lore, "§fSegún el dinero ganado, se multiplicara");
        
        slot(4, Material.STONE, "§7§lCUBO",
            Enchantment_Lore, "§fCrea un cuadrado §e7x7");
        
        slot(5, Material.REDSTONE, "§c§lLASER",
            Enchantment_Lore, "§fQuita una §6capa entera§f de la mina");
    }

    private void slot(int slot, Material material, String name, String lore, String description){
        List<String> buffered = new ArrayList<String>();
        buffered.add(lore);

        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(buffered);
        item.setItemMeta(meta);

        INV.setItem(slot, item);
    }

    public Inventory getInventory(){
        return INV;
    }
}