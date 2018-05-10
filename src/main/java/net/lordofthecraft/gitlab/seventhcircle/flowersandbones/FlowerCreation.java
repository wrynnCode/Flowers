package net.lordofthecraft.gitlab.seventhcircle.flowersandbones;

import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
public class FlowerCreation {

    public void createFlower(Block block){

        ItemStack flower = new ItemStack(block.getState().getData().toItemStack(1));
        block.getWorld().dropItemNaturally(block.getLocation(), flower);

    }


}
