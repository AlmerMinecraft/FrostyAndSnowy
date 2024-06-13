package almer.snowyandfrosty.client;

import com.google.common.collect.ImmutableMap;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModels;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.SynchronousResourceReloader;

import java.util.Map;

@Environment(EnvType.CLIENT)
public class ModEntityModelLoader implements SynchronousResourceReloader {
    private Map<EntityModelLayer, TexturedModelData> modelParts = ImmutableMap.of();

    public ModEntityModelLoader() {
    }

    public ModelPart getModelPart(EntityModelLayer layer) {
        TexturedModelData texturedModelData = (TexturedModelData)this.modelParts.get(layer);
        return texturedModelData.createModel();
    }

    public void reload(ResourceManager manager) {
        this.modelParts = ImmutableMap.copyOf(EntityModels.getModels());
    }
}
