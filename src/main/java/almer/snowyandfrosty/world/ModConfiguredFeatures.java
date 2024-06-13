package almer.snowyandfrosty.world;

import almer.snowyandfrosty.FrostyAndSnowy;
import almer.snowyandfrosty.blocks.BlueberryBushBlock;
import almer.snowyandfrosty.blocks.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.intprovider.WeightedListIntProvider;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.CherryFoliagePlacer;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.root.AboveRootPlacement;
import net.minecraft.world.gen.root.MangroveRootPlacement;
import net.minecraft.world.gen.root.MangroveRootPlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.PredicatedStateProvider;
import net.minecraft.world.gen.stateprovider.RandomizedIntBlockStateProvider;
import net.minecraft.world.gen.treedecorator.AttachedToLeavesTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.minecraft.world.gen.trunk.UpwardsBranchingTrunkPlacer;

import java.util.List;
import java.util.Optional;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> WILLOW_KEY = registerKey("willow");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PEAT_KEY = registerKey("peat");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUEBERRY_KEY = registerKey("patch_blueberry_bush");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        register(context, PEAT_KEY, Feature.DISK, new DiskFeatureConfig(PredicatedStateProvider.of(ModBlocks.PEAT), BlockPredicate.matchingBlocks(List.of(Blocks.DIRT, Blocks.CLAY, ModBlocks.PEAT)), UniformIntProvider.create(2, 3), 1));

        register(context, WILLOW_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.WILLOW_LOG),
                new CherryTrunkPlacer(6, 2, 0,
                        ConstantIntProvider.create(3), ConstantIntProvider.create(2),
                        UniformIntProvider.create(-3, 0), UniformIntProvider.create(0, 0)),
                BlockStateProvider.of(ModBlocks.WILLOW_LEAVES),
                new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(5),
                        0.2f, 0, 0.4f, 0.2f),
                new TwoLayersFeatureSize(1, 0, 2)).build());
        register(context, BLUEBERRY_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of((BlockState)ModBlocks.BLUEBERRY_BUSH.getDefaultState().with(BlueberryBushBlock.AGE, 3))));
    }
    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String id){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(FrostyAndSnowy.MOD_ID, id));
    }
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
