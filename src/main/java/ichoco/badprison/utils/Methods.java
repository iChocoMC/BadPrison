package ichoco.badprison.utils;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class Methods {
    
    Material AIR = Material.AIR;
    Random random = new Random();

    public byte lucky(int amount){
        if (amount >= 1000000){
            return 4;
        }
        if (amount >= 500000){
            return 3;
        }
        return 2;
    }

    public void cuboid(int radius, int radiusY, int X, int Z, int Y, World world){
        Block block;
        int minX = X-radius,
            minZ = Z-radius,
            maxY = Y+radiusY,
            maxX = X+radius,
            maxZ = Z+radius;

        for (int x = minX; x <= maxX; x++){
            for (int z = minZ; z <= maxZ; z++){
                for (int y = Y; y <= maxY; y++){
                    block = world.getBlockAt(x, y, z);
                    block.setType(AIR);
                    }
                }
            }
        }
    

    public void laser(int Y, World world){
        if (Y > 0){
            for (byte x = -50; x <= 50; x++){
                for (byte z = -50; z <= 50; z++){
                    world.getBlockAt(x, Y, z).setType(AIR);
                }
            }
        }
    }
}