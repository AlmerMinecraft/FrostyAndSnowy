package com.terraformersmc.terraform.boat.api.item;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.impl.item.TerraformBoatDispenserBehavior;
import com.terraformersmc.terraform.boat.impl.item.TerraformBoatItem;
import net.minecraft.block.DispenserBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public final class TerraformBoatItemHelper {
    private TerraformBoatItemHelper() {
        return;
    }
    public static Item registerBoatItem(Identifier id, RegistryKey<TerraformBoatType> boatKey, boolean chest) {
        return registerBoatItem(id, boatKey, chest, new Item.Settings().maxCount(1));
    }
    public static Item registerBoatItem(Identifier id, RegistryKey<TerraformBoatType> boatKey, boolean chest, Item.Settings settings) {
        Item item = new TerraformBoatItem(boatKey, chest, settings);
        Registry.register(Registries.ITEM, id, item);

        registerBoatDispenserBehavior(item, boatKey, chest);
        return item;
    }
    public static void registerBoatDispenserBehavior(ItemConvertible item, RegistryKey<TerraformBoatType> boatKey, boolean chest) {
        DispenserBlock.registerBehavior(item, new TerraformBoatDispenserBehavior(boatKey, chest));
    }
}
