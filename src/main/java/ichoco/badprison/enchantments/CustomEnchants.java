package ichoco.badprison.enchantments;

import ichoco.badprison.BadPrisonMAIN;
import ichoco.badprison.utils.MessageUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomEnchants extends Enchantment {
  private static String format = BadPrisonMAIN.getInstance().getConfig().getString("enchant-format");
  private String name;
  private int maxLvl;

  public CustomEnchants(int id, String name, int maxLvl) {
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
  
  /*
   * Unique methods
   */
  protected static ArrayList<Enchantment> listEnchantments = new ArrayList<>();

  public static void register() {
    for (Enchantment enchantment : listEnchantments){
      try {
        Enchantment.registerEnchantment(enchantment);
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
  }

  public static void enchantItem(ItemStack item, int level, Player player, Enchantment enchantment) {
    if (level > enchantment.getMaxLevel()) {
      player.sendMessage(MessageUtil.translate(
        "&4&lERROR: &cEl nivel maximo para este encantamiento es: ") + enchantment.getMaxLevel());
      return;
    } 
    boolean containsEnchantment = false;
    byte line = 0;
    ItemMeta meta = item.getItemMeta();

    List<String> lore = meta.getLore();
    String
      name = enchantment.getName(),
      message = MessageUtil.translate(format.replace("{enchant}", enchantment.getName()));

    for (String string : lore){
      if (string.contains(name)){
        lore.set(line, message + level);
        containsEnchantment = true;
        break;
      }
      line++;
    }
    if (!containsEnchantment){
      lore.add(message + level);
    }
    meta.setLore(lore);
    item.setItemMeta(meta);
    item.addUnsafeEnchantment(enchantment, level);
  }
}
