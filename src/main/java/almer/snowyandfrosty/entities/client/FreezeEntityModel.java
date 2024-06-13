package almer.snowyandfrosty.entities.client;

import almer.snowyandfrosty.entities.FreezeEntity;
import almer.snowyandfrosty.entities.client.animations.FreezeEntityModelAnimation;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class FreezeEntityModel<T extends FreezeEntity> extends SinglePartEntityModel<T> {
	private final ModelPart freeze;
	private final ModelPart head;
	private final ModelPart rods1;
	private final ModelPart rod1;
	private final ModelPart rod2;
	private final ModelPart rod3;
	private final ModelPart rods2;
	private final ModelPart rod4;
	private final ModelPart rod5;
	private final ModelPart rod6;
	public FreezeEntityModel(ModelPart root) {
		this.freeze = root.getChild("freeze");
		this.head = this.freeze.getChild("head");
		this.rods1 = this.freeze.getChild("rods1");
		this.rod1 = this.rods1.getChild("rod1");
		this.rod2 = this.rods1.getChild("rod2");
		this.rod3 = this.rods1.getChild("rod3");
		this.rods2 = this.freeze.getChild("rods2");
		this.rod4 = this.rods2.getChild("rod4");
		this.rod5 = this.rods2.getChild("rod5");
		this.rod6 = this.rods2.getChild("rod6");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData freeze = modelPartData.addChild("freeze", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData head = freeze.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -10.4F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData rods1 = freeze.addChild("rods1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData rod1 = rods1.addChild("rod1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData rod1_r1 = rod1.addChild("rod1_r1", ModelPartBuilder.create().uv(8, 28).cuboid(-5.8F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -14.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		ModelPartData rod2 = rods1.addChild("rod2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData rod2_r1 = rod2.addChild("rod2_r1", ModelPartBuilder.create().uv(0, 28).cuboid(-5.8F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -14.0F, 0.0F, -2.7403F, 1.0556F, -2.7173F));

		ModelPartData rod3 = rods1.addChild("rod3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData rod3_r1 = rod3.addChild("rod3_r1", ModelPartBuilder.create().uv(24, 16).cuboid(-5.8F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -14.0F, 0.0F, 2.9062F, -0.9754F, -2.8106F));

		ModelPartData rods2 = freeze.addChild("rods2", ModelPartBuilder.create(), ModelTransform.of(0.0F, -6.8F, 0.0F, 0.0F, 0.0F, -3.1416F));

		ModelPartData rod4 = rods2.addChild("rod4", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 18.4F, 0.0F));

		ModelPartData rod1_r2 = rod4.addChild("rod1_r2", ModelPartBuilder.create().uv(8, 16).cuboid(-5.2486F, -5.7661F, -1.2557F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-2.2993F, -18.1257F, 0.2557F, 0.0F, 0.0F, -0.1309F));

		ModelPartData rod5 = rods2.addChild("rod5", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 18.4F, 0.0F));

		ModelPartData rod2_r2 = rod5.addChild("rod2_r2", ModelPartBuilder.create().uv(16, 16).cuboid(-6.9079F, -5.9883F, -0.0129F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.2993F, -18.1257F, 2.2557F, -2.7403F, 1.0556F, -2.7173F));

		ModelPartData rod6 = rods2.addChild("rod6", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 18.4F, 0.0F));

		ModelPartData rod3_r2 = rod6.addChild("rod3_r2", ModelPartBuilder.create().uv(0, 16).cuboid(-7.3467F, -6.127F, -1.9504F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.5007F, -18.1257F, -1.7443F, 2.9062F, -0.9754F, -2.8106F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		freeze.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
	@Override
	public ModelPart getPart() {
		return freeze;
	}
	@Override
	public void setAngles(FreezeEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(headYaw, headPitch);

		this.updateAnimation(entity.idleAnimationState, FreezeEntityModelAnimation.FREEZE_IDLE, animationProgress, 1f);
	}
	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}
}