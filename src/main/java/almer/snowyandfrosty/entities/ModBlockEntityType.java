package almer.snowyandfrosty.entities;

import almer.snowyandfrosty.FrostyAndSnowy;
import almer.snowyandfrosty.blocks.CalibratedHopperBlockEntity;
import almer.snowyandfrosty.blocks.ModBlocks;
import com.mojang.datafixers.types.Type;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.HopperBlockEntity;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Util;

public class ModBlockEntityType<T extends BlockEntity> {
    public static final BlockEntityType<CalibratedHopperBlockEntity> CALIBRATED_HOPPER = Registry.register(Registries.BLOCK_ENTITY_TYPE, "calibrated_hopper", BlockEntityType.Builder.create(CalibratedHopperBlockEntity::new, ModBlocks.CALIBRATED_HOPPER).build(Util.getChoiceType(TypeReferences.BLOCK_ENTITY, "calibrated_hopper")));

    public static void registerBlockEntities(){
        FrostyAndSnowy.LOGGER.info("Registering block entities for: " + FrostyAndSnowy.MOD_ID);
    }
}
