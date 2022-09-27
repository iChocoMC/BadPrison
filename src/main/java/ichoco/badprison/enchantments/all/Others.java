package ichoco.badprison.enchantments.all;

import org.bukkit.enchantments.Enchantment;

import ichoco.badprison.enchantments.CustomEnchants;

public class Others {
    
    private static Enchantment lucky;

    public Others(){
        lucky = new Lucky();
    }
    
    public class Lucky extends CustomEnchants{
        public Lucky() {
            super(104, "Suerte", 30);
        }
    }
    public static Enchantment getLucky() { return lucky; }
}
