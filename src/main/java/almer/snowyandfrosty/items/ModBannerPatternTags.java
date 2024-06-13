package almer.snowyandfrosty.items;

import net.minecraft.block.entity.BannerPattern;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BannerPatternTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBannerPatternTags {
    public static final TagKey<BannerPattern> CRYSTAL_PATTERN_ITEM = ModBannerPatternTags.of("pattern_item/crystal");
    private ModBannerPatternTags() {
    }
    private static TagKey<BannerPattern> of(String id) {
        return TagKey.of(RegistryKeys.BANNER_PATTERN, new Identifier(id));
    }
}
