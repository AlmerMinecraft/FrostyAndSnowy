package almer.snowyandfrosty.blocks;

import almer.snowyandfrosty.FrostyAndSnowy;
import almer.snowyandfrosty.blocks.impl.*;
import almer.snowyandfrosty.world.tree.WillowSaplingGenerator;
import com.terraformersmc.terraform.sign.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class ModBlocks {
    public static final Block CALCITE_BRICKS = registerBlock("calcite_bricks", new Block(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_WHITE).instrument(Instrument.BASEDRUM).sounds(BlockSoundGroup.CALCITE).requiresTool().strength(0.75F)));
    public static final Block CHISELED_CALCITE = registerBlock("chiseled_calcite", new Block(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_WHITE).instrument(Instrument.BASEDRUM).sounds(BlockSoundGroup.CALCITE).requiresTool().strength(0.75F)));
    public static final Block CRACKED_CALCITE_BRICKS = registerBlock("cracked_calcite_bricks", new Block(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_WHITE).instrument(Instrument.BASEDRUM).sounds(BlockSoundGroup.CALCITE).requiresTool().strength(0.75F)));
    public static final Block POLISHED_CALCITE = registerBlock("polished_calcite", new Block(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_WHITE).instrument(Instrument.BASEDRUM).sounds(BlockSoundGroup.CALCITE).requiresTool().strength(0.75F)));
    public static final Block CALCITE_SLAB = registerBlock("calcite_slab", new SlabBlock(AbstractBlock.Settings.copyShallow(Blocks.CALCITE)));
    public static final Block CALCITE_BRICKS_SLAB = registerBlock("calcite_bricks_slab", new SlabBlock(AbstractBlock.Settings.copyShallow(CALCITE_BRICKS)));
    public static final Block POLISHED_CALCITE_SLAB = registerBlock("polished_calcite_slab", new SlabBlock(AbstractBlock.Settings.copyShallow(POLISHED_CALCITE)));
    public static final Block CALCITE_STAIRS = registerBlock("calcite_stairs", new StairsBlock(Blocks.CALCITE.getDefaultState(), AbstractBlock.Settings.copyShallow(Blocks.CALCITE)));
    public static final Block CALCITE_BRICKS_STAIRS = registerBlock("calcite_bricks_stairs", new StairsBlock(CALCITE_BRICKS.getDefaultState(), AbstractBlock.Settings.copyShallow(CALCITE_BRICKS)));
    public static final Block POLISHED_CALCITE_STAIRS = registerBlock("polished_calcite_stairs", new StairsBlock(POLISHED_CALCITE.getDefaultState(), AbstractBlock.Settings.copyShallow(POLISHED_CALCITE)));
    public static final Block CALCITE_WALL = registerBlock("calcite_wall", new WallBlock(AbstractBlock.Settings.copyShallow(Blocks.CALCITE).solid()));
    public static final Block CALCITE_BRICKS_WALL = registerBlock("calcite_bricks_wall", new WallBlock(AbstractBlock.Settings.copyShallow(CALCITE_BRICKS).solid()));
    public static final Block POLISHED_CALCITE_WALL = registerBlock("polished_calcite_wall", new WallBlock(AbstractBlock.Settings.copyShallow(POLISHED_CALCITE).solid()));

    public static final Block WILLOW_LOG = registerBlock("willow_log", new PillarBlock(AbstractBlock.Settings.create().mapColor((state) -> {
        return state.get(PillarBlock.AXIS) == Direction.Axis.Y ? MapColor.LIGHT_GRAY : MapColor.GRAY;
    }).instrument(Instrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block STRIPPED_WILLOW_LOG = registerBlock("stripped_willow_log", new PillarBlock(AbstractBlock.Settings.create().mapColor((state) -> {
        return state.get(PillarBlock.AXIS) == Direction.Axis.Y ? MapColor.LIGHT_GRAY : MapColor.LIGHT_GRAY;
    }).instrument(Instrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block WILLOW_WOOD = registerBlock((String)"willow_wood", new PillarBlock(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_GRAY).instrument(Instrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block STRIPPED_WILLOW_WOOD = registerBlock((String)"stripped_willow_wood", new PillarBlock(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_GRAY).instrument(Instrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block WILLOW_LEAVES = registerBlock("willow_leaves", new LeavesBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never)));
    public static final Block WILLOW_PLANKS = registerBlock("willow_planks", new Block(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_GRAY).instrument(Instrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block WILLOW_STAIRS = registerBlock("willow_stairs", new StairsBlock(WILLOW_PLANKS.getDefaultState(), AbstractBlock.Settings.copyShallow(WILLOW_PLANKS)));
    public static final Block WILLOW_SLAB = registerBlock("willow_slab", new SlabBlock(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_GRAY).instrument(Instrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block WILLOW_FENCE = registerBlock("willow_fence", new FenceBlock(AbstractBlock.Settings.create().mapColor(WILLOW_PLANKS.getDefaultMapColor()).solid().instrument(Instrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block WILLOW_FENCE_GATE = registerBlock("willow_fence_gate", new FenceGateBlock(ModWoodType.WILLOW, AbstractBlock.Settings.create().mapColor(WILLOW_PLANKS.getDefaultMapColor()).solid().instrument(Instrument.BASS).strength(2.0F, 3.0F).burnable()));
    public static final Block WILLOW_DOOR = registerBlock("willow_door", new DoorBlock(ModBlockSetType.WILLOW, AbstractBlock.Settings.create().mapColor(WILLOW_PLANKS.getDefaultMapColor()).instrument(Instrument.BASS).strength(3.0F).nonOpaque().burnable().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILLOW_TRAPDOOR = registerBlock("willow_trapdoor", new TrapdoorBlock(ModBlockSetType.WILLOW, AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_GRAY).instrument(Instrument.BASS).strength(3.0F).nonOpaque().allowsSpawning(Blocks::never).burnable()));
    public static final Block WILLOW_PRESSURE_PLATE = registerBlock("willow_pressure_plate", new PressurePlateBlock(ModBlockSetType.WILLOW, AbstractBlock.Settings.create().mapColor(WILLOW_PLANKS.getDefaultMapColor()).solid().instrument(Instrument.BASS).noCollision().strength(0.5F).burnable().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILLOW_BUTTON = registerBlock("willow_button", new ButtonBlock(ModBlockSetType.WILLOW, 30, AbstractBlock.Settings.create().noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILLOW_SAPLING = registerBlock("willow_sapling", new SaplingBlock(WillowSaplingGenerator.WILLOW, AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block POTTED_WILLOW_SAPLING = registerBlock("potted_willow_sapling", new FlowerPotBlock(WILLOW_SAPLING, AbstractBlock.Settings.create().breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Identifier WILLOW_SIGN_TEXTURE = new Identifier(FrostyAndSnowy.MOD_ID, "entity/signs/willow");
    public static final Identifier WILLOW_HANGING_SIGN_TEXTURE = new Identifier(FrostyAndSnowy.MOD_ID, "entity/signs/hanging/willow");
    public static final Identifier WILLOW_HANGING_GUI_SIGN_TEXTURE = new Identifier(FrostyAndSnowy.MOD_ID, "textures/gui/hanging_signs/willow");
    public static final Block WILLOW_SIGN = Registry.register(Registries.BLOCK, new Identifier(FrostyAndSnowy.MOD_ID, "willow_sign"),
            new TerraformSignBlock(WILLOW_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_SIGN)));
    public static final Block WILLOW_WALL_SIGN = Registry.register(Registries.BLOCK, new Identifier(FrostyAndSnowy.MOD_ID, "willow_wall_sign"),
            new TerraformWallSignBlock(WILLOW_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN).dropsLike(WILLOW_SIGN)));
    public static final Block WILLOW_HANGING_SIGN = Registry.register(Registries.BLOCK, new Identifier(FrostyAndSnowy.MOD_ID, "willow_hanging_sign"),
            new TerraformHangingSignBlock(WILLOW_HANGING_SIGN_TEXTURE, WILLOW_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN)));
    public static final Block WILLOW_WALL_HANGING_SIGN = Registry.register(Registries.BLOCK, new Identifier(FrostyAndSnowy.MOD_ID, "willow_wall_hanging_sign"),
            new TerraformWallHangingSignBlock(WILLOW_HANGING_SIGN_TEXTURE, WILLOW_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_HANGING_SIGN).dropsLike(WILLOW_HANGING_SIGN)));

    public static final Block BLUEBERRY_BUSH = registerBlock("blueberry_bush", new BlueberryBushBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).ticksRandomly().noCollision().sounds(BlockSoundGroup.SWEET_BERRY_BUSH).pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block FROZEN_SOIL = registerBlock("frozen_soil", new Block(AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).ticksRandomly().strength(0.6F).sounds(BlockSoundGroup.GLASS)));
    public static final Block PEAT = registerBlock("peat", new PeatBlock(AbstractBlock.Settings.create().mapColor(MapColor.BROWN).burnable().strength(0.6F).sounds(BlockSoundGroup.MOSS_BLOCK)));
    public static final Block SAWMILL = registerBlock("sawmill", new SawmillBlock(AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASEDRUM).requiresTool().strength(3.5F)));
    public static final Block CHISELED_ICE = registerBlock("chiseled_ice", new Block(AbstractBlock.Settings.copyShallow(Blocks.PACKED_ICE)));
    public static final Block CALIBRATED_HOPPER = registerBlock("calibrated_hopper", new CalibratedHopperBlock(AbstractBlock.Settings.copyShallow(Blocks.HOPPER)));

    public static Block registerBlock(String id, Block block){
        return Registry.register(Registries.BLOCK, new Identifier(FrostyAndSnowy.MOD_ID, id), block);
    }
    public static void registerBlocks(){
        FrostyAndSnowy.LOGGER.info("Registering blocks for: " + FrostyAndSnowy.MOD_ID);
    }
}
