package ichoco.badprison.enchantments.blocks;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;

import ichoco.badprison.enchantments.CustomEnchants;

public class Cuboid extends CustomEnchants {

    private static Enchantment enchantment = new Cuboid();

    private Cuboid() {
        super(102, "Cuboid", 80, enchantment);
    }

    public static void method(World world, int X, int Z, int Y, int radius) {
        int minX = negative(X-radius),
            minZ = negative(Z-radius),
            maxY = Y+radius*2,
            maxX = positive(X+radius),
            maxZ = positive(Z+radius);

        for (int x = minX; x <= maxX; x++){
            for (int z = minZ; z <= maxZ; z++){
                for (int y = Y; y <= maxY; y++){
                    world.getBlockAt(x, y, z).setType(Material.AIR);
                }
            }
        }
    }

    private static int negative(int cord){
        if (cord < -50){
            int diference = cord+50;
            cord = cord+diference;
        }
        return cord;
    }

    private static int positive(int cord){
        if (cord > 50){
            int diference = cord-50;
            cord = cord-diference;
        }
        return cord;
    }

    public static Enchantment getEnchantment(){
        return enchantment;
    }
}

