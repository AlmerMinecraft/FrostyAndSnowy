package almer.snowyandfrosty.client;

import almer.snowyandfrosty.entities.RavenEntity;
import almer.snowyandfrosty.entities.client.RavenEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RotationAxis;

@Environment(value= EnvType.CLIENT)
public class RavenHeldItemFeatureRenderer extends FeatureRenderer<RavenEntity, RavenEntityModel> {
    private final HeldItemRenderer heldItemRenderer;
    public RavenHeldItemFeatureRenderer(FeatureRendererContext<RavenEntity, RavenEntityModel> context, HeldItemRenderer heldItemRenderer) {
        super(context);
        this.heldItemRenderer = heldItemRenderer;
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, RavenEntity ravenEntity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        float m;
        boolean bl = ravenEntity.isSleeping();
        boolean bl2 = ravenEntity.isBaby();
        matrices.push();
        if (bl2) {
            m = 0.75f;
            matrices.scale(0.75f, 0.75f, 0.75f);
            matrices.translate(0.0f, 0.5f, 0.209375f);
        }
        if (ravenEntity.isBaby()) {
            if (bl) {
                matrices.translate(0.4f, 0.26f, 0.15f);
            } else {
                matrices.translate(0.06f, 0.26f, -0.5f);
            }
        } else if (bl) {
            matrices.translate(0.46f, 0.26f, 0.22f);
        } else {
            matrices.translate(0.06f, 0.27f, -0.5f);
        }
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0f));
        if (bl) {
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90.0f));
        }
        ItemStack itemStack = ravenEntity.getEquippedStack(EquipmentSlot.MAINHAND);
        this.heldItemRenderer.renderItem(ravenEntity, itemStack, ModelTransformationMode.GROUND, false, matrices, vertexConsumers, light);
        matrices.pop();
    }
}
