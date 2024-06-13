package almer.snowyandfrosty.items;

import net.minecraft.block.entity.BannerPattern;
import net.minecraft.block.entity.BannerPatterns;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModBannerPatterns {
    public static final RegistryKey<BannerPattern> CRYSTAL = ModBannerPatterns.of("crystal");
    private static RegistryKey<BannerPattern> of(String id) {
        return RegistryKey.of(RegistryKeys.BANNER_PATTERN, new Identifier(id));
    }
    public static BannerPattern registerAndGetDefault(Registry<BannerPattern> registry) {
        return Registry.register(registry, CRYSTAL, new BannerPattern("cry"));
    }
}
