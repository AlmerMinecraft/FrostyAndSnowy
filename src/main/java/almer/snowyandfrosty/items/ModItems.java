package almer.snowyandfrosty.items;

import almer.snowyandfrosty.FrostyAndSnowy;
import almer.snowyandfrosty.blocks.ModBlocks;
import almer.snowyandfrosty.entities.ModBoats;
import almer.snowyandfrosty.entities.ModEntityType;
import almer.snowyandfrosty.sound.ModSoundEvents;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.entity.DecoratedPotBlockEntity;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item CALCITE_BRICKS = register("calcite_bricks", new BlockItem(ModBlocks.CALCITE_BRICKS, new FabricItemSettings()));
    public static final Item CHISELED_CALCITE = register("chiseled_calcite", new BlockItem(ModBlocks.CHISELED_CALCITE, new FabricItemSettings()));
    public static final Item CRACKED_CALCITE_BRICKS = register("cracked_calcite_bricks", new BlockItem(ModBlocks.CRACKED_CALCITE_BRICKS, new FabricItemSettings()));
    public static final Item POLISHED_CALCITE = register("polished_calcite", new BlockItem(ModBlocks.POLISHED_CALCITE, new FabricItemSettings()));
    public static final Item CALCITE_SLAB = register("calcite_slab", new BlockItem(ModBlocks.CALCITE_SLAB, new FabricItemSettings()));
    public static final Item CALCITE_BRICKS_SLAB = register("calcite_bricks_slab", new BlockItem(ModBlocks.CALCITE_BRICKS_SLAB, new FabricItemSettings()));
    public static final Item POLISHED_CALCITE_SLAB = register("polished_calcite_slab", new BlockItem(ModBlocks.POLISHED_CALCITE_SLAB, new FabricItemSettings()));
    public static final Item CALCITE_STAIRS = register("calcite_stairs", new BlockItem(ModBlocks.CALCITE_STAIRS, new FabricItemSettings()));
    public static final Item CALCITE_BRICKS_STAIRS = register("calcite_bricks_stairs", new BlockItem(ModBlocks.CALCITE_BRICKS_STAIRS, new FabricItemSettings()));
    public static final Item POLISHED_CALCITE_STAIRS = register("polished_calcite_stairs", new BlockItem(ModBlocks.POLISHED_CALCITE_STAIRS, new FabricItemSettings()));
    public static final Item CALCITE_WALL = register("calcite_wall", new BlockItem(ModBlocks.CALCITE_WALL, new FabricItemSettings()));
    public static final Item CALCITE_BRICKS_WALL = register("calcite_bricks_wall", new BlockItem(ModBlocks.CALCITE_BRICKS_WALL, new FabricItemSettings()));
    public static final Item POLISHED_CALCITE_WALL = register("polished_calcite_wall", new BlockItem(ModBlocks.POLISHED_CALCITE_WALL, new FabricItemSettings()));

    public static final Item WILLOW_LOG = register("willow_log", new BlockItem(ModBlocks.WILLOW_LOG, new FabricItemSettings()));
    public static final Item WILLOW_WOOD = register("willow_wood", new BlockItem(ModBlocks.WILLOW_WOOD, new FabricItemSettings()));
    public static final Item STRIPPED_WILLOW_LOG = register("stripped_willow_log", new BlockItem(ModBlocks.STRIPPED_WILLOW_LOG, new FabricItemSettings()));
    public static final Item STRIPPED_WILLOW_WOOD = register("stripped_willow_wood", new BlockItem(ModBlocks.STRIPPED_WILLOW_WOOD, new FabricItemSettings()));
    public static final Item WILLOW_PLANKS = register("willow_planks", new BlockItem(ModBlocks.WILLOW_PLANKS, new FabricItemSettings()));
    public static final Item WILLOW_STAIRS = register("willow_stairs", new BlockItem(ModBlocks.WILLOW_STAIRS, new FabricItemSettings()));
    public static final Item WILLOW_SLAB = register("willow_slab", new BlockItem(ModBlocks.WILLOW_SLAB, new FabricItemSettings()));
    public static final Item WILLOW_FENCE = register("willow_fence", new BlockItem(ModBlocks.WILLOW_FENCE, new FabricItemSettings()));
    public static final Item WILLOW_FENCE_GATE = register("willow_fence_gate", new BlockItem(ModBlocks.WILLOW_FENCE_GATE, new FabricItemSettings()));
    public static final Item WILLOW_PRESSURE_PLATE = register("willow_pressure_plate", new BlockItem(ModBlocks.WILLOW_PRESSURE_PLATE, new FabricItemSettings()));
    public static final Item WILLOW_BUTTON = register("willow_button", new BlockItem(ModBlocks.WILLOW_BUTTON, new FabricItemSettings()));
    public static final Item WILLOW_SAPLING = register("willow_sapling", new BlockItem(ModBlocks.WILLOW_SAPLING, new FabricItemSettings()));
    public static final Item WILLOW_SIGN = register("willow_sign", new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.WILLOW_SIGN, ModBlocks.WILLOW_WALL_SIGN));
    public static final Item WILLOW_HANGING_SIGN = register("willow_hanging_sign", new HangingSignItem(ModBlocks.WILLOW_HANGING_SIGN, ModBlocks.WILLOW_WALL_HANGING_SIGN, new FabricItemSettings().maxCount(16)));
    public static final Item WILLOW_DOOR = register("willow_door", new BlockItem(ModBlocks.WILLOW_DOOR, new FabricItemSettings()));
    public static final Item WILLOW_TRAPDOOR = register("willow_trapdoor", new BlockItem(ModBlocks.WILLOW_TRAPDOOR, new FabricItemSettings()));
    public static final Item WILLOW_LEAVES = register("willow_leaves", new BlockItem(ModBlocks.WILLOW_LEAVES, new FabricItemSettings()));
    public static final Item WILLOW_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.WILLOW_BOAT_ID, ModBoats.WILLOW_BOAT_KEY, false);
    public static final Item WILLOW_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.WILLOW_CHEST_BOAT_ID, ModBoats.WILLOW_BOAT_KEY, true);

    public static final Item BLUEBERRY = register("blueberry", new AliasedBlockItem(ModBlocks.BLUEBERRY_BUSH, new FabricItemSettings().food(ModFoodComponents.BLUEBERRY)));

    public static final Item FROZEN_SOIL = register("frozen_soil", new BlockItem(ModBlocks.FROZEN_SOIL, new FabricItemSettings()));
    public static final Item PEAT = register("peat", new BlockItem(ModBlocks.PEAT, new FabricItemSettings()));
    public static final Item SAWMILL = register("sawmill", new BlockItem(ModBlocks.SAWMILL, new FabricItemSettings()));
    public static final Item CHISELED_ICE = register("chiseled_ice", new BlockItem(ModBlocks.CHISELED_ICE, new FabricItemSettings()));
    public static final Item CALIBRATED_HOPPER = register("calibrated_hopper", new BlockItem(ModBlocks.CALIBRATED_HOPPER, new FabricItemSettings()));

    public static final Item SLINGSHOT = register("slingshot", new SlingshotItem(new FabricItemSettings().maxCount(1).maxDamage(100)));
    public static final Item BERRY_MIX = register("berry_mix", new StewItem(new FabricItemSettings().food(ModFoodComponents.BERRY_MIX).maxCount(1)));
    public static final Item CRYSTAL_BANNER_PATTERN = register("crystal_banner_pattern", new BannerPatternItem(ModBannerPatternTags.CRYSTAL_PATTERN_ITEM, new Item.Settings().maxCount(1)));
    public static final Item AURORA_ARMOR_TRIM_SMITHING_TEMPLATE = register("aurora_armor_trim_smithing_template", SmithingTemplateItem.of(ModArmorTrimPatterns.AURORA));
    public static final Item MUSIC_DISC_FROZEN = register("music_disc_frozen", new MusicDiscItem(12, ModSoundEvents.MUSIC_DISC_FROZEN, new Item.Settings().maxCount(1).rarity(Rarity.RARE), 120));
    public static final Item RAVEN_SPAWN_EGG = register("raven_spawn_egg", new SpawnEggItem(ModEntityType.RAVEN, 0x1a1a1c, 0xd18b21, new FabricItemSettings()));
    public static final Item SNAIL_SPAWN_EGG = register("snail_spawn_egg", new SpawnEggItem(ModEntityType.SNAIL, 0xc4c493, 0xb3a574, new FabricItemSettings()));
    public static final Item ICEPER_SPAWN_EGG = register("iceper_spawn_egg", new SpawnEggItem(ModEntityType.ICEPER, 0x78a9d6, 0x2f2f4f, new FabricItemSettings()));
    public static final Item FREEZE_SPAWN_EGG = register("freeze_spawn_egg", new SpawnEggItem(ModEntityType.FREEZE, 0x5b94c9, 0x749bd4, new FabricItemSettings()));

    public static Item register(String id, Item item){
        return Registry.register(Registries.ITEM, new Identifier(FrostyAndSnowy.MOD_ID, id), item);
    }
    public static void registerItems(){
        FrostyAndSnowy.LOGGER.info("Registering items for: " + FrostyAndSnowy.MOD_ID);
    }
}
