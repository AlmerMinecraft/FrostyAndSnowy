/*
 * Decompiled with CFR 0.2.2 (FabricMC 7c48b8c4).
 */
package almer.snowyandfrosty.entities.client;

import almer.snowyandfrosty.entities.FreezeEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(value=EnvType.CLIENT)
public class FreezeEntityRenderer
extends MobEntityRenderer<FreezeEntity, FreezeEntityModel<FreezeEntity>> {
    private static final Identifier TEXTURE = new Identifier("textures/entity/freeze.png");
    public FreezeEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new FreezeEntityModel(context.getPart(ModModelLayer.FREEZE_LAYER)), 0.5f);
        this.addFeature(new FreezeEyesFeatureRenderer<FreezeEntity>(this));
    }
    @Override
    public Identifier getTexture(FreezeEntity blazeEntity) {
        return TEXTURE;
    }
}

