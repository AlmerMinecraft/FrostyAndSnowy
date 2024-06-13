package almer.snowyandfrosty.mixin;

import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Properties.class)
public class MixinProperties {
    @Shadow
    @Final
    @Mutable
    @SuppressWarnings("unused")
    public static IntProperty DISTANCE_1_7 = IntProperty.of("distance", 1, 14);
}
