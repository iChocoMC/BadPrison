package ichoco.badprison.enchantments.others;

import org.bukkit.enchantments.Enchantment;

import ichoco.badprison.enchantments.CustomEnchants;

public class Lucky extends CustomEnchants {

    private static Enchantment enchantment = new Lucky();

    private Lucky() {
        super(104, "Lucky", 30, enchantment);
    }

    public static int method(int amount) {
        if (amount >= 1000000){
            return 4*amount; 
        }
        if (amount >= 500000){
            return 3*amount; 
        }
        return 2*amount;
    }
    
    public static Enchantment getEnchantment(){
        return enchantment;
    }
}

