package almer.snowyandfrosty.entities.client;

import almer.snowyandfrosty.FrostyAndSnowy;
import almer.snowyandfrosty.entities.CobblestoneEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.*;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.WindChargeEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.WindChargeEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

@Environment(EnvType.CLIENT)
public class CobblestoneRenderer extends EntityRenderer<CobblestoneEntity> {
    private static final Identifier TEXTURE = new Identifier("textures/entity/projectile/cobblestone.png");
    private final CobblestoneModel model;

    public CobblestoneRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new CobblestoneModel(context.getPart(ModModelLayer.COBBLESTONE));
    }

    @Override
    public void render(CobblestoneEntity windChargeEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        float h = (float)windChargeEntity.age + g;
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(RenderLayer.getEntityTranslucent(TEXTURE));
        this.model.setAngles(windChargeEntity, 0.0f, 0.0f, h, 0.0f, 0.0f);
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1f);
        super.render(windChargeEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
    @Override
    public Identifier getTexture(CobblestoneEntity windChargeEntity) {
        return TEXTURE;
    }
}
