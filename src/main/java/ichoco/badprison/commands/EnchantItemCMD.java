package ichoco.badprison.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import ichoco.badprison.enchantments.CustomEnchants;
import ichoco.badprison.utils.MessageUtil;

public class EnchantItemCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (args.length == 2) {
            ItemStack item = player.getItemInHand();
            int level = Integer.parseInt(args[1]);
            Enchantment enchantment = Enchantment.getByName(args[0]);

            if (level > enchantment.getMaxLevel()) {
                player.sendMessage(MessageUtil.translate("&4&lERROR: &cEl nivel maximo para este encantamiento es:" + enchantment.getMaxLevel()));
                return true;
            }
            CustomEnchants.enchantItem(item, level, player, enchantment);
            player.sendMessage(MessageUtil.translate("&aHas encantado tu herramienta con: &e" + enchantment + "&a al nivel &e" + level));
            return true;
        }
        CorrectUsage(player);

        return false;
    }
    private void CorrectUsage(Player player){
        player.sendMessage(MessageUtil.translate(
            "\n" +
            "&9&lBadPrison &8| &bEncantamiento" +
            "\n" +
            " &fUso:" +
            "\n &7/benchant + &aencantamiento &7+ &anivel" +
            "\n"));
    }
}