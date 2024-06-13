package almer.snowyandfrosty.world.gen;

import almer.snowyandfrosty.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModPeatGeneration {
    public static void generatePeat(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SWAMP),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.PEAT_PLACED_KEY);
    }
}
