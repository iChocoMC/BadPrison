package ichoco.badprison.menus.listeners;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import ichoco.badprison.enchantments.CustomEnchants;
import ichoco.badprison.enchantments.all.Blocks;
import ichoco.badprison.enchantments.all.Others;
import ichoco.badprison.menus.PickaxeMenu;

public class InventoryListener implements Listener {
  
    @EventHandler
    public void click(InventoryClickEvent event) {
      if (event.getInventory().equals(PickaxeMenu.getInventory())){
        switch (event.getCurrentItem().getType()) {
          case STONE:
            enchant(event.getClick(), (Enchantment)Blocks.getCuboid(), event.getWhoClicked().getItemInHand(), (Player) event.getWhoClicked());
          break;
          
          case EMERALD_BLOCK:
            enchant(event.getClick(), (Enchantment)Others.getLucky(), event.getWhoClicked().getItemInHand(), (Player) event.getWhoClicked());
          break;
          
          case REDSTONE:
            enchant(event.getClick(), (Enchantment)Blocks.getLaser(), event.getWhoClicked().getItemInHand(), (Player) event.getWhoClicked());
          break;
          
          default:
          break;

          }
        event.setCancelled(true);
      }
    }
    
  
    public void enchant(ClickType click, Enchantment enchantment, ItemStack item, Player player) {
        if (click.isLeftClick()){
          CustomEnchants.enchantItem(item, item.getEnchantmentLevel(enchantment) + 1, player, enchantment);
        } else if (click.isRightClick()){
          CustomEnchants.enchantItem(item, item.getEnchantmentLevel(enchantment) + 10, player, enchantment);
      }
    }
}
