package almer.snowyandfrosty.entities;

import almer.snowyandfrosty.FrostyAndSnowy;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.resource.featuretoggle.ToggleableFeature;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypeFilter;
import org.jetbrains.annotations.Nullable;

public class ModEntityType{
    public static final EntityType<CobblestoneEntity> COBBLESTONE = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(FrostyAndSnowy.MOD_ID, "cobblestone"),
            FabricEntityTypeBuilder.<CobblestoneEntity>create(SpawnGroup.MISC, CobblestoneEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10).build());
    public static final EntityType<IceBitEntity> ICE_BIT = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(FrostyAndSnowy.MOD_ID, "ice_bit"),
            FabricEntityTypeBuilder.<IceBitEntity>create(SpawnGroup.MISC, IceBitEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10).build());
    public static final EntityType<RavenEntity> RAVEN = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(FrostyAndSnowy.MOD_ID, "raven"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RavenEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.9f)).build()
    );
    public static final EntityType<SnailEntity> SNAIL = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(FrostyAndSnowy.MOD_ID, "snail"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SnailEntity::new)
                    .dimensions(EntityDimensions.fixed(0.3f, 0.3f)).build()
    );
    public static final EntityType<IceperEntity> ICEPER = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(FrostyAndSnowy.MOD_ID, "iceper"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, IceperEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.7f)).build()
    );
    public static final EntityType<FreezeEntity> FREEZE = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(FrostyAndSnowy.MOD_ID, "freeze"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FreezeEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.8f)).build()
    );
}
