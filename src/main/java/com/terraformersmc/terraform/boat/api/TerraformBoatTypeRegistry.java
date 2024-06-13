package com.terraformersmc.terraform.boat.api;

import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class TerraformBoatTypeRegistry {
    private static final Identifier REGISTRY_ID = new Identifier("terraform", "boat");
    public static final Registry<TerraformBoatType> INSTANCE = FabricRegistryBuilder.createSimple(TerraformBoatType.class, REGISTRY_ID).buildAndRegister();

    public static RegistryKey<TerraformBoatType> createKey(Identifier id) {
        return RegistryKey.of(INSTANCE.getKey(), id);
    }
}
