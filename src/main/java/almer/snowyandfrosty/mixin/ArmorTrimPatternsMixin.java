package almer.snowyandfrosty.mixin;

import almer.snowyandfrosty.items.ModArmorTrimPatterns;
import almer.snowyandfrosty.items.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.trim.ArmorTrimPattern;
import net.minecraft.item.trim.ArmorTrimPatterns;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
@Mixin(ArmorTrimPatterns.class)
public class ArmorTrimPatternsMixin{
    private static void register(Registerable<ArmorTrimPattern> registry, Item template, RegistryKey<ArmorTrimPattern> key) {
        ArmorTrimPattern armorTrimPattern = new ArmorTrimPattern(key.getValue(), Registries.ITEM.getEntry(template), Text.translatable(Util.createTranslationKey("trim_pattern", key.getValue())), false);
        registry.register(key, armorTrimPattern);
    }
    @Inject(method = "bootstrap(Lnet/minecraft/registry/Registerable;)V", at = @At("TAIL"))
    private static void bootstrap(Registerable<ArmorTrimPattern> registry, CallbackInfo ci){
        ArmorTrimPatternsMixin.register(registry, ModItems.AURORA_ARMOR_TRIM_SMITHING_TEMPLATE, ModArmorTrimPatterns.AURORA);
    }
}
