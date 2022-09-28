package ichoco.badprison.enchantments.others;

import org.bukkit.enchantments.Enchantment;

import ichoco.badprison.enchantments.CustomEnchants;

public class Lucky extends CustomEnchants {

    private static Enchantment enchantment = new Lucky();

    public Lucky() {
        super(104, "Lucky", 30);
        listEnchantments.add(enchantment);
    }

    public static byte method(int amount) {
        if (amount >= 1000000){
            return 4; 
        }
        if (amount >= 500000){
            return 3; 
        }
        return 2;
    }
    
    public static Enchantment getEnchantment(){
        return enchantment;
    }
}

