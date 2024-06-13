package almer.snowyandfrosty.entities;

import almer.snowyandfrosty.FrostyAndSnowy;
import almer.snowyandfrosty.blocks.ModBlocks;
import almer.snowyandfrosty.items.ModItems;
import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModBoats {
    public static final Identifier WILLOW_BOAT_ID = new Identifier(FrostyAndSnowy.MOD_ID, "willow_boat");
    public static final Identifier WILLOW_CHEST_BOAT_ID = new Identifier(FrostyAndSnowy.MOD_ID, "willow_chest_boat");

    public static final RegistryKey<TerraformBoatType> WILLOW_BOAT_KEY = TerraformBoatTypeRegistry.createKey(WILLOW_BOAT_ID);

    public static void registerBoats() {
        TerraformBoatType willowBoat = new TerraformBoatType.Builder()
                .item(ModItems.WILLOW_BOAT)
                .chestItem(ModItems.WILLOW_CHEST_BOAT)
                .planks(ModBlocks.WILLOW_PLANKS.asItem())
                .build();

        Registry.register(TerraformBoatTypeRegistry.INSTANCE, WILLOW_BOAT_KEY, willowBoat);
    }
}
