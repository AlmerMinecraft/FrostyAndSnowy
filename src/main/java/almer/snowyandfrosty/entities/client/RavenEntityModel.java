package almer.snowyandfrosty.entities.client;

import almer.snowyandfrosty.entities.RavenEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class RavenEntityModel extends EntityModel<RavenEntity> {
	private final ModelPart body;
	private final ModelPart wing0;
	private final ModelPart wing1;
	private final ModelPart head;
	private final ModelPart tail;
	private final ModelPart leg0;
	private final ModelPart leg1;
	public RavenEntityModel(ModelPart root) {
		this.body = root.getChild("body");
		this.wing0 = body.getChild("wing0");
		this.wing1 = body.getChild("wing1");
		this.head = root.getChild("head");
		this.tail = root.getChild("tail");
		this.leg0 = root.getChild("leg0");
		this.leg1 = root.getChild("leg1");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create(), ModelTransform.of(0.0F, 16.5F, -3.0F, 0.4363F, 0.0F, 0.0F));

		ModelPartData body_r1 = body.addChild("body_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, -8.0657F, -3.9343F, 3.0F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 7.5F, 3.0F, 0.3491F, 0.0F, 0.0F));

		ModelPartData wing0 = body.addChild("wing0", ModelPartBuilder.create(), ModelTransform.of(1.5F, 0.4F, 0.2F, 0.1745F, 0.0F, 0.0F));

		ModelPartData wing0_r1 = wing0.addChild("wing0_r1", ModelPartBuilder.create().uv(7, 14).cuboid(1.0F, -7.1F, -4.3F, 1.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, 7.1F, 2.8F, 0.1745F, 0.0F, 0.0F));

		ModelPartData wing1 = body.addChild("wing1", ModelPartBuilder.create(), ModelTransform.of(-1.5F, 0.4F, 0.2F, 0.1745F, 0.0F, 0.0F));

		ModelPartData wing1_r1 = wing1.addChild("wing1_r1", ModelPartBuilder.create().uv(10, 6).cuboid(-2.0F, -7.1F, -4.3F, 1.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, 7.1F, 2.8F, 0.1745F, 0.0F, 0.0F));

		ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 9).cuboid(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 3.0F, new Dilation(0.0F))
		.uv(12, 14).cuboid(-0.5F, -1.1F, -1.9F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(16, 14).cuboid(-0.5F, -0.4F, -2.9F, 1.0F, 1.7F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 16.9F, -5.6F));

		ModelPartData tail = modelPartData.addChild("tail", ModelPartBuilder.create().uv(12, 0).cuboid(-1.5F, -0.7429F, -1.3064F, 3.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 21.1F, 1.2F, 0.8727F, 0.0F, 0.0F));

		ModelPartData leg0 = modelPartData.addChild("leg0", ModelPartBuilder.create().uv(15, 5).cuboid(-1.0F, -0.5F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(1.5F, 23.0F, -0.5F));

		ModelPartData leg1 = modelPartData.addChild("leg1", ModelPartBuilder.create().uv(0, 15).cuboid(-1.0F, -0.5F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, 23.0F, -0.5F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(RavenEntity ravenEntity, float f, float g, float h, float i, float j) {
		this.setAngles(RavenEntityModel.getPose(ravenEntity), f, g, h, i, j);
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		tail.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		leg0.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		leg1.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
	private void setAngles(RavenEntityModel.Pose pose, float limbAngle, float limbDistance, float age, float headYaw, float headPitch) {
		switch (pose) {
			case STANDING: {
			}
			default: {
				float h = age * 0.3f;
				this.tail.pitch = 1.015f + MathHelper.cos(limbAngle * 0.6662f) * 0.3f * limbDistance;
				this.tail.pivotY = 21.07f + h;
				this.body.pivotY = 16.5f + h;
				this.wing0.roll = -0.0873f - age;
				this.wing1.roll = 0.0873f + age;
			}
		}
	}
	private static RavenEntityModel.Pose getPose(RavenEntity raven) {
		if (raven.isInAir()) {
			return RavenEntityModel.Pose.FLYING;
		}
		return RavenEntityModel.Pose.STANDING;
	}
	@Environment(value= EnvType.CLIENT)
	public static enum Pose {
		FLYING,
		STANDING,
	}
}