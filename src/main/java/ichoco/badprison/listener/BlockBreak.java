package ichoco.badprison.listener;

import java.util.Random;

import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import ichoco.badprison.BadPrisonMAIN;
import ichoco.badprison.enchantments.blocks.*;
import ichoco.badprison.enchantments.others.*;

import net.milkbowl.vault.economy.Economy;

public class BlockBreak implements Listener {

    private Random random = new Random();
    private Economy economy = BadPrisonMAIN.getEconomy();
    
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void event(BlockBreakEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();
        ItemStack item = player.getItemInHand();
        int percentage = random.nextInt(100),
            fortune = item.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS),
            amount = fortune;
        
        if (item.getEnchantmentLevel(Cuboid.getEnchantment()) > percentage){
            Cuboid.method(block.getWorld(), block.getX(), block.getZ(), block.getY(), 3);
            amount+=343 * fortune;
        }
        if (item.getEnchantmentLevel(Laser.getEnchantment()) > percentage){
            Laser.method(block.getWorld(), block.getY());
            amount+=10201 * fortune;
        }
        if (item.getEnchantmentLevel(Lucky.getEnchantment()) > percentage){
            amount=Lucky.method(amount);
        }
        economy.depositPlayer(player, amount);
    }
}