package almer.snowyandfrosty.entities.client;

import almer.snowyandfrosty.FrostyAndSnowy;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayer {
    public static final EntityModelLayer COBBLESTONE =
            new EntityModelLayer(new Identifier(FrostyAndSnowy.MOD_ID, "cobblestone"), "main");
    public static final EntityModelLayer ICE_BIT =
            new EntityModelLayer(new Identifier(FrostyAndSnowy.MOD_ID, "ice_bit"), "main");
    public static final EntityModelLayer RAVEN_LAYER =
            new EntityModelLayer(new Identifier(FrostyAndSnowy.MOD_ID, "raven"), "main");
    public static final EntityModelLayer SNAIL_LAYER =
            new EntityModelLayer(new Identifier(FrostyAndSnowy.MOD_ID, "snail"), "main");
    public static final EntityModelLayer FREEZE_LAYER =
            new EntityModelLayer(new Identifier(FrostyAndSnowy.MOD_ID, "freeze"), "main");
}
