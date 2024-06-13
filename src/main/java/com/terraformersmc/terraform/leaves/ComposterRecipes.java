package com.terraformersmc.terraform.leaves;

import com.terraformersmc.terraform.leaves.block.ExtendedLeavesBlock;
import com.terraformersmc.terraform.leaves.block.LeafPileBlock;
import net.minecraft.block.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;

public class ComposterRecipes {
    private static void registerCompostableItem(ItemConvertible item, float chance) {
        if (item.asItem() != Items.AIR) {
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(item.asItem(), chance);
        }
    }
    public static void registerCompostableBlock(Block block) {
        if (block instanceof ExtendedLeavesBlock || block instanceof LeavesBlock || block instanceof LeafPileBlock || block instanceof SaplingBlock || block instanceof SeagrassBlock) {
            registerCompostableItem(block, 0.3F);
        } else if (block instanceof GrassBlock || block instanceof FlowerBlock) {
            registerCompostableItem(block, 0.65F);
        }
    }
}
