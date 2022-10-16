package ichoco.badprison.enchantments;

import ichoco.badprison.utils.MessageUtil;

import java.util.List;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomEnchants extends Enchantment {
  private String name;
  private int maxLvl;

  protected CustomEnchants(int id, String name, int maxLvl, Enchantment enchantment) {
    super(id);
    this.name = name;
    this.maxLvl = maxLvl;
  }

  public String getName() {
    return this.name;
  }
  
  public int getMaxLevel() {
    return this.maxLvl;
  }
  
  public int getStartLevel() {
    return 1;
  }
  
  public EnchantmentTarget getItemTarget() {
    return null;
  }
  
  public boolean conflictsWith(Enchantment other) {
    return false;
  }
  
  public boolean canEnchantItem(ItemStack item) {
    return false;
  }

  public static void enchantItem(ItemStack item, int level, Player player, Enchantment enchantment) {
    if (level > enchantment.getMaxLevel()) {
      player.sendMessage("§4§lERROR: §cEl nivel maximo para este encantamiento es: §6" + enchantment.getMaxLevel());
      return;
    }
    boolean containsEnchantment = false;
    byte line = 0;
    ItemMeta meta = item.getItemMeta();

    List<String> lore = meta.getLore();
    String
      name = enchantment.getName(),
      enchantment_format = MessageUtil.Enchantment_Format;
    
      enchantment_format.replace("{enchant}", enchantment.getName());

    for (String string : lore){
      if (string.contains(name)){
        lore.set(line, enchantment_format + level);
        containsEnchantment = true;
        break;
      }
      line++;
    }

    if (!containsEnchantment){
      lore.add(enchantment_format + level);
    }

    meta.setLore(lore);
    item.setItemMeta(meta);
    item.addUnsafeEnchantment(enchantment, level);
  }
}
