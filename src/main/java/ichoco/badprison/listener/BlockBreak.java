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
import ichoco.badprison.enchantments.all.Blocks;
import ichoco.badprison.enchantments.all.Others;
import ichoco.badprison.utils.Methods;

import net.milkbowl.vault.economy.Economy;

public class BlockBreak implements Listener {

    private Methods methods = new Methods();
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
        
        if (item.getEnchantmentLevel(Blocks.getCuboid()) > percentage){
            methods.cuboid(3, 6, block.getX(), block.getZ(), block.getY(), block.getWorld());
            amount+=343 * fortune;
        }
        if (item.getEnchantmentLevel(Blocks.getLaser()) > percentage){
            methods.laser(block.getY(), block.getWorld());
            amount+=10201 * fortune;
        }
        if (item.getEnchantmentLevel(Others.getLucky()) > percentage){
            amount*=methods.lucky(amount);
        }
        economy.depositPlayer(player, amount);
    }
}