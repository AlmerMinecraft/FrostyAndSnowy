package almer.snowyandfrosty.items;

import net.minecraft.block.entity.BannerPattern;
import net.minecraft.block.entity.BannerPatterns;
import net.minecraft.data.DataOutput;
import net.minecraft.data.server.tag.TagProvider;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BannerPatternTags;

import java.util.concurrent.CompletableFuture;

public class ModBannerPatternProvider extends TagProvider<BannerPattern> {
    public ModBannerPatternProvider(DataOutput dataGenerator, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookupFuture) {
        super(dataGenerator, RegistryKeys.BANNER_PATTERN, registryLookupFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        this.getOrCreateTagBuilder(ModBannerPatternTags.CRYSTAL_PATTERN_ITEM).add(BannerPatterns.CREEPER);
    }
}
