package almer.snowyandfrosty.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.registry.DynamicRegistryManager;
import com.mojang.datafixers.util.Pair;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.world.World;

import java.util.List;

public class SawmillRecipe implements Recipe<Inventory> {
    private final ItemStack result;
    private final Pair<Ingredient, Integer> ingredientPair;
    public SawmillRecipe(ItemStack result, Pair<Ingredient, Integer> ingredientPair) {
        this.result = result;
        this.ingredientPair = ingredientPair;
    }

    @Override
    public boolean matches(Inventory inventory, World world) {
        return ingredientPair.getFirst().test(inventory.getStack(0));
    }

    @Override
    public ItemStack craft(Inventory inventory, DynamicRegistryManager registryManager) {
        return result.copy();
    }
    public Pair<Ingredient, Integer> getIngredientPair() {
        return ingredientPair;
    }
    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(DynamicRegistryManager registryManager) {
        return result;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<SawmillRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "sawmilling";
    }

    public static class Serializer implements RecipeSerializer<SawmillRecipe> {

        public static final Serializer INSTANCE = new Serializer();
        public static final Codec<SawmillRecipe> CODEC = RecordCodecBuilder.create(in -> in.group(
                ItemStack.RECIPE_RESULT_CODEC.fieldOf("result").forGetter(r -> r.result),
                Codec.pair(Ingredient.DISALLOW_EMPTY_CODEC, Codec.INT.optionalFieldOf("count", 1)
                        .codec()).fieldOf("ingredient").forGetter(r -> r.ingredientPair)
        ).apply(in, SawmillRecipe::new));
        public static final String ID = "sawmilling";
        @Override
        public Codec<SawmillRecipe> codec() {
            return CODEC;
        }

        @Override
        public SawmillRecipe read(PacketByteBuf buf) {
            Ingredient ingredient = Ingredient.fromPacket(buf);
            int ingredientCount = buf.readInt();
            ItemStack result = buf.readItemStack();

            return new SawmillRecipe(result, new Pair(ingredient, ingredientCount));
        }

        @Override
        public void write(PacketByteBuf buf, SawmillRecipe recipe) {
            Pair<Ingredient, Integer> ingredientPair = recipe.getIngredientPair();
            ingredientPair.getFirst().write(buf);
            buf.writeInt(ingredientPair.getSecond());

            buf.writeItemStack(recipe.result);
        }
    }
}
