package ichoco.badprison.enchantments.all;

import org.bukkit.enchantments.Enchantment;

import ichoco.badprison.enchantments.CustomEnchants;

public class Blocks {
    
    private static Enchantment
        cuboid,
        laser;

    public Blocks(){
        cuboid = new Cuboid();
        laser = new Laser();
    }
    
    public class Cuboid extends CustomEnchants{
        public Cuboid() {
            super(102, "Cuboid", 80);
        }
    }
    
    public class Laser extends CustomEnchants{
        public Laser() {
            super(103, "Laser", 5);
        }
    }
    public static Enchantment getCuboid() { return cuboid; }
    public static Enchantment getLaser() { return laser; }
}
