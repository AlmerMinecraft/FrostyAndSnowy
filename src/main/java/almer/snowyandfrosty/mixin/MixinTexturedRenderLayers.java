package almer.snowyandfrosty.mixin;

import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Iterator;
import java.util.function.Consumer;

@Mixin(TexturedRenderLayers.class)
public class MixinTexturedRenderLayers {
    @Inject(method = "addDefaultTextures", at = @At("RETURN"))
    private static void terraformWood$injectSignTextures(Consumer<SpriteIdentifier> consumer, CallbackInfo ci) {
        for (SpriteIdentifier identifier: SpriteIdentifierRegistry.INSTANCE.getIdentifiers()) {
            consumer.accept(identifier);
        }
    }
}
