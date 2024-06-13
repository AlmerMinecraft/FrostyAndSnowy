package almer.snowyandfrosty.recipe;

import almer.snowyandfrosty.FrostyAndSnowy;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static almer.snowyandfrosty.FrostyAndSnowy.MOD_ID;

public class ModRecipeTypes {
    public static RecipeType<SawmillRecipe> SAWMILLING = Registry.register(Registries.RECIPE_TYPE,
            new Identifier(MOD_ID, SawmillRecipe.Type.ID), SawmillRecipe.Type.INSTANCE);
    public static void registerRecipeTypes() {
        FrostyAndSnowy.LOGGER.info("Register recipe types");
    }
}
