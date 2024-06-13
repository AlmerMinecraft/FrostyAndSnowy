/*
 * Decompiled with CFR 0.2.2 (FabricMC 7c48b8c4).
 */
package almer.snowyandfrosty.entities.client;

import almer.snowyandfrosty.client.RavenHeldItemFeatureRenderer;
import almer.snowyandfrosty.entities.RavenEntity;
import almer.snowyandfrosty.entities.SnailEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

@Environment(value=EnvType.CLIENT)
public class SnailEntityRenderer extends MobEntityRenderer<SnailEntity, SnailEntityModel> {
    private static final Identifier TEXTURE = new Identifier("textures/entity/snail.png");
    public SnailEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new SnailEntityModel(context.getPart(ModModelLayer.SNAIL_LAYER)), 0.3f);
    }
    @Override
    public Identifier getTexture(SnailEntity parrotEntity) {
        return TEXTURE;
    }
}

