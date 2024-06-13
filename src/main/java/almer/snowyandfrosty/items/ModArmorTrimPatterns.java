package almer.snowyandfrosty.items;

import net.minecraft.item.trim.ArmorTrimPattern;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModArmorTrimPatterns {
    public static final RegistryKey<ArmorTrimPattern> AURORA = ModArmorTrimPatterns.of("aurora");
    private static RegistryKey<ArmorTrimPattern> of(String id) {
        return RegistryKey.of(RegistryKeys.TRIM_PATTERN, new Identifier(id));
    }
}
