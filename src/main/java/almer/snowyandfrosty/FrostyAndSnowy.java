package almer.snowyandfrosty;

import almer.snowyandfrosty.blocks.ModBlocks;
import almer.snowyandfrosty.client.screen.CalibratedHopperScreenHandler;
import almer.snowyandfrosty.client.screen.SawmillScreenHandler;
import almer.snowyandfrosty.entities.*;
import almer.snowyandfrosty.items.*;
import almer.snowyandfrosty.recipe.ModRecipeSerializer;
import almer.snowyandfrosty.recipe.ModRecipeTypes;
import almer.snowyandfrosty.util.ModVillagerTrades;
import almer.snowyandfrosty.world.ModPlacedFeatures;
import almer.snowyandfrosty.world.gen.ModWorldGeneration;
import almer.snowyandfrosty.world.structure.IceTempleStructure;
import almer.snowyandfrosty.world.structure.ShelterStructure;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.DecoratedPotPatterns;
import net.minecraft.entity.DamageUtil;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.HopperScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.structure.StructureType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrostyAndSnowy implements ModInitializer {
	public static final String MOD_ID = "minecraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final ScreenHandlerType<SawmillScreenHandler> SAWMILL_SCREEN_HANDLER = register(MOD_ID, SawmillScreenHandler::new);
	public static final ScreenHandlerType<CalibratedHopperScreenHandler> CALIBRATED_HOPPER_SCREEN_HANDLER = register("calibrated_hopper", CalibratedHopperScreenHandler::new);
	public static final StructureType<ShelterStructure> SHELTER_TYPE = Registry.register(Registries.STRUCTURE_TYPE, new Identifier(MOD_ID, "shelter"), () -> ShelterStructure.CODEC);
	public static final StructureType<IceTempleStructure> ICE_TEMPLE_TYPE = Registry.register(Registries.STRUCTURE_TYPE, new Identifier(MOD_ID, "ice_temple"), () -> IceTempleStructure.CODEC);
	private static <T extends ScreenHandler> ScreenHandlerType<T> register(String id, ScreenHandlerType.Factory<T> factory) {
		return Registry.register(Registries.SCREEN_HANDLER, id, new ScreenHandlerType<T>(factory, FeatureFlags.VANILLA_FEATURES));
	}
	@Override
	public void onInitialize() {
		ModItems.registerItems();
		ModItemGroup.registerGroups();
		ModBlocks.registerBlocks();
		ModBlockEntityType.registerBlockEntities();

		StrippableBlockRegistry.register(ModBlocks.WILLOW_LOG, ModBlocks.STRIPPED_WILLOW_LOG);
		StrippableBlockRegistry.register(ModBlocks.WILLOW_WOOD, ModBlocks.STRIPPED_WILLOW_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.WILLOW_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.WILLOW_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_WILLOW_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_WILLOW_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.WILLOW_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.WILLOW_LEAVES, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PEAT, 30, 60);

		FuelRegistry.INSTANCE.add(ModItems.PEAT, 1600);

		ModBoats.registerBoats();
		ModWorldGeneration.generateModWorldGen();

		ModRecipeTypes.registerRecipeTypes();
		ModRecipeSerializer.registerRecipeSerializer();
		ModBannerPatterns.registerAndGetDefault(Registries.BANNER_PATTERN);

		FabricDefaultAttributeRegistry.register(ModEntityType.RAVEN, RavenEntity.createRavenAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityType.SNAIL, SnailEntity.createSnailAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityType.ICEPER, IceperEntity.createIceperAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityType.FREEZE, FreezeEntity.createFreezeAttributes());

		ModVillagerTrades.registerTrades();
	}
}