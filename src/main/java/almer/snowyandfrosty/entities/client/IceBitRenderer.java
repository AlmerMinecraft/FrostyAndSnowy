package almer.snowyandfrosty.entities.client;

import almer.snowyandfrosty.entities.CobblestoneEntity;
import almer.snowyandfrosty.entities.IceBitEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class IceBitRenderer extends EntityRenderer<IceBitEntity> {
    private static final Identifier TEXTURE = new Identifier("textures/entity/projectile/ice_bit.png");
    private final IceBitModel model;

    public IceBitRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new IceBitModel(context.getPart(ModModelLayer.ICE_BIT));
    }

    @Override
    public void render(IceBitEntity windChargeEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        float h = (float)windChargeEntity.age + g;
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(RenderLayer.getEntityTranslucent(TEXTURE));
        this.model.setAngles(windChargeEntity, 0.0f, 0.0f, h, 0.0f, 0.0f);
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1f);
        super.render(windChargeEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
    @Override
    public Identifier getTexture(IceBitEntity windChargeEntity) {
        return TEXTURE;
    }
}
