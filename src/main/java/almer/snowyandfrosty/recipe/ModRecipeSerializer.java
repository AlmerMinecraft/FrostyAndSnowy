package almer.snowyandfrosty.recipe;

import almer.snowyandfrosty.FrostyAndSnowy;
import com.mojang.serialization.Codec;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.CuttingRecipe;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.StonecuttingRecipe;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static almer.snowyandfrosty.FrostyAndSnowy.MOD_ID;

public interface ModRecipeSerializer<T extends Recipe<?>> {
    public static void registerRecipeSerializer() {
        FrostyAndSnowy.LOGGER.info("Register recipe serializer");

        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(MOD_ID, SawmillRecipe.Serializer.ID),
                SawmillRecipe.Serializer.INSTANCE);
    }
}
