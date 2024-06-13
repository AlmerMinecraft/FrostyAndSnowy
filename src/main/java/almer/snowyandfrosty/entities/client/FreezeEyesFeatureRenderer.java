package almer.snowyandfrosty.entities.client;

import almer.snowyandfrosty.entities.FreezeEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class FreezeEyesFeatureRenderer<T extends FreezeEntity> extends EyesFeatureRenderer {
    private static final RenderLayer SKIN = RenderLayer.getEyes(new Identifier("textures/entity/freeze_e.png"));
    public FreezeEyesFeatureRenderer(FeatureRendererContext featureRendererContext) {
        super(featureRendererContext);
    }
    @Override
    public RenderLayer getEyesTexture() {
        return SKIN;
    }
}
