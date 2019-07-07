package net.lordofthecraft.flowers;

import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class Flowers extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }


    @EventHandler
    public void PlayerInteractEvent(PlayerInteractEvent event){
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getHand() == EquipmentSlot.HAND) {
            Player player = event.getPlayer();
            Block block = event.getClickedBlock();
            ItemStack item = player.getInventory().getItemInMainHand();

            if (isBoneMeal(item) && isFlower(block) && player.hasPermission("flowers.use")) {
                if (player.getGameMode() == GameMode.CREATIVE) return;
                consumeItem(item);
                createFlower(block);
                block.getWorld().playEffect(block.getLocation(), Effect.VILLAGER_PLANT_GROW, 6);
            }
        }

    }

    private boolean isBoneMeal(ItemStack item){
        return (item.getType() == Material.BONE_MEAL);
    }

    private boolean isFlower(Block block){
        Material blocktype = block.getType();

        switch (blocktype){
            case ROSE_RED: case DANDELION: case POPPY: case BLUE_ORCHID: case ALLIUM: case AZURE_BLUET: case ORANGE_TULIP:
            case PINK_TULIP: case RED_TULIP: case WHITE_TULIP: case OXEYE_DAISY:
                return true;
            default:
                break;
        }
        return false;
    }

    private void consumeItem(ItemStack item){
        item.setAmount(item.getAmount() - 1);
    }

    public void createFlower(Block block){

        ItemStack flower = new ItemStack(block.getState().getData().toItemStack(1));
        block.getWorld().dropItemNaturally(block.getLocation(), flower);

    }
}
