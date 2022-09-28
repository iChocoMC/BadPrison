package ichoco.badprison.enchantments.blocks;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;

import ichoco.badprison.enchantments.CustomEnchants;

public class Cuboid extends CustomEnchants {

    private static Enchantment enchantment = new Cuboid();

    public Cuboid() {
        super(102, "Cuboid", 80);
        listEnchantments.add(enchantment);
    }

    public static void method(World world, int X, int Z, int Y, int radius) {
        int minX = X-radius,
            minZ = Z-radius,
            maxY = Y+radius*2,
            maxX = X+radius,
            maxZ = Z+radius;

        Block block = null;

        for (int x = minX; x <= maxX; x++){
            for (int z = minZ; z <= maxZ; z++){
                for (int y = Y; y <= maxY; y++){
                    block = world.getBlockAt(x, y, z);
                    block.setType(Material.AIR);
                }
            }
        }
    }
    
    public static Enchantment getEnchantment(){
        return enchantment;
    }
}

