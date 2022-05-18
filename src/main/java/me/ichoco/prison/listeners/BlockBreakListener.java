package me.ichoco.prison.listeners;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.isCancelled()) {
            return;
        }
        Block block = event.getBlock();
        
        block.getDrops().forEach(drops -> drops(event.getPlayer(), block, drops));
    }

    private void drops(Player player, Block block, ItemStack item) {
        ItemStack pItem = player.getItemInHand();
        if (pItem.hasItemMeta() && pItem.getItemMeta().hasEnchant(Enchantment.LOOT_BONUS_BLOCKS)) {
            int level = pItem.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
            int random = (new Random()).nextInt(level) + 1;
            item.setAmount(random);
        }
        player.getInventory().addItem(item);
        block.setType(Material.AIR);
    }
}
