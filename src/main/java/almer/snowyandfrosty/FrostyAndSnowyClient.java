package almer.snowyandfrosty;

import almer.snowyandfrosty.blocks.ModBlocks;
import almer.snowyandfrosty.client.screen.CalibratedHopperScreen;
import almer.snowyandfrosty.client.screen.SawmillScreen;
import almer.snowyandfrosty.entities.ModBoats;
import almer.snowyandfrosty.entities.ModEntityType;
import almer.snowyandfrosty.entities.client.*;
import almer.snowyandfrosty.items.ModItems;
import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;

@Environment(EnvType.CLIENT)
public class FrostyAndSnowyClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILLOW_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_WILLOW_SAPLING, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILLOW_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUEBERRY_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SAWMILL, RenderLayer.getCutout());

        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.WILLOW_SIGN_TEXTURE));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.WILLOW_HANGING_SIGN_TEXTURE));

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x87ba86, ModItems.WILLOW_LEAVES);

        TerraformBoatClientHelper.registerModelLayers(ModBoats.WILLOW_BOAT_ID, false);
        HandledScreens.register(FrostyAndSnowy.SAWMILL_SCREEN_HANDLER, SawmillScreen::new);
        HandledScreens.register(FrostyAndSnowy.CALIBRATED_HOPPER_SCREEN_HANDLER, CalibratedHopperScreen::new);

        EntityRendererRegistry.register(ModEntityType.COBBLESTONE, CobblestoneRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayer.COBBLESTONE, CobblestoneModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntityType.ICE_BIT, IceBitRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayer.ICE_BIT, IceBitModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntityType.RAVEN, RavenEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayer.RAVEN_LAYER, RavenEntityModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntityType.SNAIL, SnailEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayer.SNAIL_LAYER, SnailEntityModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntityType.ICEPER, IceperEntityRenderer::new);

        EntityRendererRegistry.register(ModEntityType.FREEZE, FreezeEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayer.FREEZE_LAYER, FreezeEntityModel::getTexturedModelData);
    }
}
