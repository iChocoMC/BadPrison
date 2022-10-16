package ichoco.badprison.enchantments.blocks;


import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;

import ichoco.badprison.enchantments.CustomEnchants;

public class Laser extends CustomEnchants {

    private static Enchantment enchantment = new Laser();

    private Laser() {
        super(103, "Laser", 5, enchantment);
    }

    public static void method(World world, int Y) {
        Block block = null;
        
        if (Y < 0){ return; }

        for (int x = -50; x <= 50; x++){
            for (int z = -50; z <= 50; z++){
                block = world.getBlockAt(x, Y, z);
                block.setType(Material.AIR);
            }
        }
    }
    
    public static Enchantment getEnchantment(){
        return enchantment;
    }

    public static void getMethod(World world, int Y){
        method(world, Y);
    }
}

