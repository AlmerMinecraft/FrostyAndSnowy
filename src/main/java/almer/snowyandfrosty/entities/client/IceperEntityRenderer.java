/*
 * Decompiled with CFR 0.2.2 (FabricMC 7c48b8c4).
 */
package almer.snowyandfrosty.entities.client;

import almer.snowyandfrosty.entities.IceperEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.CreeperChargeFeatureRenderer;
import net.minecraft.client.render.entity.model.CreeperEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

@Environment(value=EnvType.CLIENT)
public class IceperEntityRenderer extends MobEntityRenderer<IceperEntity, IceperEntityModel<IceperEntity>> {
    private static final Identifier TEXTURE = new Identifier("textures/entity/iceper.png");
    public IceperEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new IceperEntityModel(context.getPart(EntityModelLayers.CREEPER)), 0.5f);
    }
    @Override
    protected void scale(IceperEntity creeperEntity, MatrixStack matrixStack, float f) {
        float g = creeperEntity.getClientFuseTime(f);
        float h = 1.0f + MathHelper.sin(g * 100.0f) * g * 0.01f;
        g = MathHelper.clamp(g, 0.0f, 1.0f);
        g *= g;
        g *= g;
        float i = (1.0f + g * 0.4f) * h;
        float j = (1.0f + g * 0.1f) / h;
        matrixStack.scale(i, j, i);
    }
    @Override
    protected float getAnimationCounter(IceperEntity creeperEntity, float f) {
        float g = creeperEntity.getClientFuseTime(f);
        if ((int)(g * 10.0f) % 2 == 0) {
            return 0.0f;
        }
        return MathHelper.clamp(g, 0.5f, 1.0f);
    }

    @Override
    public Identifier getTexture(IceperEntity creeperEntity) {
        return TEXTURE;
    }

}

