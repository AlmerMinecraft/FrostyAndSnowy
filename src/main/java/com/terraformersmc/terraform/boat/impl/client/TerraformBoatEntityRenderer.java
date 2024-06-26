package com.terraformersmc.terraform.boat.impl.client;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import com.terraformersmc.terraform.boat.impl.entity.TerraformBoatHolder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.BoatEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.*;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.util.Identifier;

import java.util.Map;

@Environment(EnvType.CLIENT)
public class TerraformBoatEntityRenderer extends BoatEntityRenderer {
    private final Map<TerraformBoatType, Pair<Identifier, CompositeEntityModel<BoatEntity>>> texturesAndModels;

    public TerraformBoatEntityRenderer(EntityRendererFactory.Context context, boolean chest) {
        super(context, chest);

        this.texturesAndModels = TerraformBoatTypeRegistry.INSTANCE.getEntrySet().stream().collect(ImmutableMap.toImmutableMap(entry -> {
            return entry.getValue();
        }, entry -> {
            boolean raft = entry.getValue().isRaft();
            String prefix = raft ? (chest ? "chest_raft/" : "raft/") : (chest ? "chest_boat/" : "boat/");

            Identifier id = entry.getKey().getValue();
            Identifier textureId = new Identifier(id.getNamespace(), "textures/entity/" + prefix + id.getPath() + ".png");

            EntityModelLayer layer = TerraformBoatClientHelper.getLayer(id, raft, chest);
            CompositeEntityModel<BoatEntity> model = createModel(context.getPart(layer), raft, chest);

            return new Pair<>(textureId, model);
        }));
    }

    @Override
    public Identifier getTexture(BoatEntity entity) {
        if (entity instanceof TerraformBoatHolder) {
            TerraformBoatType boat = ((TerraformBoatHolder) entity).getTerraformBoat();
            return this.texturesAndModels.get(boat).getFirst();
        }
        return super.getTexture(entity);
    }

    public Pair<Identifier, CompositeEntityModel<BoatEntity>> getTextureAndModel(TerraformBoatHolder holder) {
        return this.texturesAndModels.get(holder.getTerraformBoat());
    }

    private CompositeEntityModel<BoatEntity> createModel(ModelPart part, boolean raft, boolean chest) {
        if (raft) {
            return chest ? new ChestRaftEntityModel(part) : new RaftEntityModel(part);
        } else {
            return chest ? new ChestBoatEntityModel(part) : new BoatEntityModel(part);
        }
    }
}