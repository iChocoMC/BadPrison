package ichoco.badprison.menus.listeners;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import ichoco.badprison.BadPrisonMAIN;
import ichoco.badprison.enchantments.CustomEnchants;
import ichoco.badprison.enchantments.blocks.*;
import ichoco.badprison.enchantments.others.*;

public class InventoryListener implements Listener {
  
  private Inventory PickaxeMenu = BadPrisonMAIN.getPickaxeInventory();

  @EventHandler
  public void click(InventoryClickEvent event) {
    if (event.getInventory().equals(PickaxeMenu)){
      switch (event.getCurrentItem().getType()) {
        case STONE:
          enchant(event.getClick(), Cuboid.getEnchantment(), (Player) event.getWhoClicked());
        break;
          
        case EMERALD_BLOCK:
          enchant(event.getClick(), Lucky.getEnchantment(), (Player) event.getWhoClicked());
        break;
          
        case REDSTONE:
          enchant(event.getClick(), Laser.getEnchantment(), (Player) event.getWhoClicked());
        break;
          
        default:
        break;

        }
      event.setCancelled(true);
    }
  }
  
  public void enchant(ClickType click, Enchantment enchantment, Player player) {
    ItemStack item = player.getItemInHand();  
    if (click.isLeftClick()){
      CustomEnchants.enchantItem(item, item.getEnchantmentLevel(enchantment) + 1, player, enchantment);
    } else if (click.isRightClick()){
      CustomEnchants.enchantItem(item, item.getEnchantmentLevel(enchantment) + 10, player, enchantment);
    }
  }
}
