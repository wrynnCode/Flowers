package net.lordofthecraft.flowers.listeners;


import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import net.lordofthecraft.flowers.FlowerCreation;



public class BoneMealListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void PlayerInteractEvent(PlayerInteractEvent event){
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK){
            Player player = event.getPlayer();
            Block block = event.getClickedBlock();
            ItemStack item = player.getInventory().getItemInMainHand();

            if (isBoneMeal(item)){
                if (isFlower(block)){
                    event.setCancelled(true);
                    consumeItem(item);
                    FlowerCreation flowerCreation = new FlowerCreation();
                    flowerCreation.createFlower(block);
                }
            }

        }
    }

    private boolean isBoneMeal(ItemStack item){
        ItemStack bonemeal = new ItemStack(Material.INK_SACK, 1,(short)15);
        return (item.getType() == bonemeal.getType());
    }

    private boolean isFlower(Block block){
        Material blocktype = block.getType();

        switch (blocktype){
            case RED_ROSE: case YELLOW_FLOWER: //Only on small flowers as big flowers have this mechanic in vanilla
                return true;
            default:
                break;
        }
        return false;
    }

    private void consumeItem(ItemStack item){
        item.setAmount(item.getAmount() - 1);
    }
}
