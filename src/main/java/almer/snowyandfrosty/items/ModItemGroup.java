package almer.snowyandfrosty.items;

import almer.snowyandfrosty.FrostyAndSnowy;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static void registerGroups(){
        FrostyAndSnowy.LOGGER.info("Registering item groups for: " + FrostyAndSnowy.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.addAfter(Items.CHERRY_BUTTON, ModItems.WILLOW_LOG);
            content.addAfter(ModItems.WILLOW_LOG, ModItems.WILLOW_WOOD);
            content.addAfter(ModItems.WILLOW_WOOD, ModItems.STRIPPED_WILLOW_LOG);
            content.addAfter(ModItems.STRIPPED_WILLOW_LOG, ModItems.STRIPPED_WILLOW_WOOD);
            content.addAfter(ModItems.STRIPPED_WILLOW_WOOD, ModItems.WILLOW_PLANKS);
            content.addAfter(ModItems.WILLOW_PLANKS, ModItems.WILLOW_STAIRS);
            content.addAfter(ModItems.WILLOW_STAIRS, ModItems.WILLOW_SLAB);
            content.addAfter(ModItems.WILLOW_SLAB, ModItems.WILLOW_FENCE);
            content.addAfter(ModItems.WILLOW_FENCE, ModItems.WILLOW_FENCE_GATE);
            content.addAfter(ModItems.WILLOW_FENCE_GATE, ModItems.WILLOW_DOOR);
            content.addAfter(ModItems.WILLOW_DOOR, ModItems.WILLOW_TRAPDOOR);
            content.addAfter(ModItems.WILLOW_TRAPDOOR, ModItems.WILLOW_PRESSURE_PLATE);
            content.addAfter(ModItems.WILLOW_PRESSURE_PLATE, ModItems.WILLOW_BUTTON);

            content.addAfter(Items.POLISHED_ANDESITE_SLAB, Items.CALCITE);
            content.addAfter(Items.CALCITE, ModItems.CALCITE_STAIRS);
            content.addAfter(ModItems.CALCITE_STAIRS, ModItems.CALCITE_SLAB);
            content.addAfter(ModItems.CALCITE_SLAB, ModItems.CALCITE_WALL);
            content.addAfter(ModItems.CALCITE_WALL, ModItems.CHISELED_CALCITE);
            content.addAfter(ModItems.CHISELED_CALCITE, ModItems.POLISHED_CALCITE);
            content.addAfter(ModItems.POLISHED_CALCITE, ModItems.POLISHED_CALCITE_STAIRS);
            content.addAfter(ModItems.POLISHED_CALCITE_STAIRS, ModItems.POLISHED_CALCITE_SLAB);
            content.addAfter(ModItems.POLISHED_CALCITE_SLAB, ModItems.POLISHED_CALCITE_WALL);
            content.addAfter(ModItems.POLISHED_CALCITE_WALL, ModItems.CALCITE_BRICKS);
            content.addAfter(ModItems.CALCITE_BRICKS, ModItems.CALCITE_BRICKS_STAIRS);
            content.addAfter(ModItems.CALCITE_BRICKS_STAIRS,ModItems.CALCITE_BRICKS_SLAB);
            content.addAfter(ModItems.CALCITE_BRICKS_SLAB, ModItems.CALCITE_BRICKS_WALL);
            content.addAfter(ModItems.CALCITE_BRICKS_WALL, ModItems.CRACKED_CALCITE_BRICKS);

            content.addAfter(Items.PACKED_ICE, ModItems.CHISELED_ICE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content ->{
            content.addAfter(Items.CHERRY_HANGING_SIGN, ModItems.WILLOW_SIGN);
            content.addAfter(ModItems.WILLOW_SIGN, ModItems.WILLOW_HANGING_SIGN);
            content.addAfter(Items.STONECUTTER, ModItems.SAWMILL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addAfter(Items.CHERRY_LEAVES, ModItems.WILLOW_LEAVES);
            content.addAfter(Items.CHERRY_SAPLING, ModItems.WILLOW_SAPLING);
            content.addAfter(Items.SWEET_BERRIES, ModItems.BLUEBERRY);
            content.addAfter(Items.MYCELIUM, ModItems.FROZEN_SOIL);
            content.addAfter(Items.CLAY, ModItems.PEAT);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(Items.CHERRY_CHEST_BOAT, ModItems.WILLOW_BOAT);
            content.addAfter(ModItems.WILLOW_BOAT, ModItems.WILLOW_CHEST_BOAT);
            content.addAfter(Items.MUSIC_DISC_PIGSTEP, ModItems.MUSIC_DISC_FROZEN);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.addAfter(Items.SWEET_BERRIES, ModItems.BLUEBERRY);
            content.addAfter(Items.MUSHROOM_STEW, ModItems.BERRY_MIX);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(content -> {
            content.addAfter(Items.HOPPER, ModItems.CALIBRATED_HOPPER);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.CROSSBOW, ModItems.SLINGSHOT);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.PIGLIN_BANNER_PATTERN, ModItems.CRYSTAL_BANNER_PATTERN);
            content.addAfter(Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE, ModItems.AURORA_ARMOR_TRIM_SMITHING_TEMPLATE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> {
            content.addAfter(Items.PARROT_SPAWN_EGG, ModItems.RAVEN_SPAWN_EGG);
            content.addAfter(Items.FROG_SPAWN_EGG, ModItems.SNAIL_SPAWN_EGG);
            content.addAfter(Items.CREEPER_SPAWN_EGG, ModItems.ICEPER_SPAWN_EGG);
            content.addAfter(Items.BLAZE_SPAWN_EGG, ModItems.FREEZE_SPAWN_EGG);
        });
    }
}
