package almer.snowyandfrosty.entities.client;

import almer.snowyandfrosty.entities.CobblestoneEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.entity.projectile.WindChargeEntity;

@Environment(EnvType.CLIENT)
public class CobblestoneModel extends SinglePartEntityModel<CobblestoneEntity> {
    private final ModelPart bone;

    public CobblestoneModel(ModelPart root) {
        this.bone = root.getChild(EntityModelPartNames.BONE);
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData modelPartData2 = modelPartData.addChild(EntityModelPartNames.BONE, ModelPartBuilder.create(), ModelTransform.pivot(0.0f, 0.0f, 0.0f));
        ModelPartData modelPartData3 = modelPartData2.addChild("projectile", ModelPartBuilder.create(), ModelTransform.pivot(0.0f, 0.0f, 0.0f));
        modelPartData3.addChild("wind_charge", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0f, 0.0f, -2.0f, 4.0f, 4.0f, 4.0f, new Dilation(0.0f)), ModelTransform.pivot(0.0f, 0.0f, 0.0f));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void setAngles(CobblestoneEntity windChargeEntity, float f, float g, float h, float i, float j) {
    }
    @Override
    public ModelPart getPart() {
        return this.bone;
    }
}
