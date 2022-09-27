package ichoco.badprison.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import ichoco.badprison.menus.PickaxeMenu;

public class PlayerInteract implements Listener {

    @EventHandler
    public void event(PlayerInteractEvent event) {
        if(!event.getPlayer().isSneaking()){ return; }

        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
            Player player = event.getPlayer();
            ItemStack item = player.getItemInHand();
            if (item.getType() == Material.DIAMOND_PICKAXE){
                player.openInventory(PickaxeMenu.getInventory());
            }
        }
    }
}