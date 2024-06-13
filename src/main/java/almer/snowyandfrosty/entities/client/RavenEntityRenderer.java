/*
 * Decompiled with CFR 0.2.2 (FabricMC 7c48b8c4).
 */
package almer.snowyandfrosty.entities.client;

import almer.snowyandfrosty.client.RavenHeldItemFeatureRenderer;
import almer.snowyandfrosty.entities.RavenEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

@Environment(value=EnvType.CLIENT)
public class RavenEntityRenderer extends MobEntityRenderer<RavenEntity, RavenEntityModel> {
    private static final Identifier TEXTURE = new Identifier("textures/entity/raven.png");
    public RavenEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new RavenEntityModel(context.getPart(ModModelLayer.RAVEN_LAYER)), 0.3f);
        this.addFeature(new RavenHeldItemFeatureRenderer(this, context.getHeldItemRenderer()));
    }
    @Override
    public Identifier getTexture(RavenEntity parrotEntity) {
        return TEXTURE;
    }
    @Override
    public float getAnimationProgress(RavenEntity parrotEntity, float f) {
        float g = MathHelper.lerp(f, parrotEntity.prevFlapProgress, parrotEntity.flapProgress);
        float h = MathHelper.lerp(f, parrotEntity.prevMaxWingDeviation, parrotEntity.maxWingDeviation);
        return (MathHelper.sin(g) + 1.0f) * h;
    }
}

