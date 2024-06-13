package almer.snowyandfrosty.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class ModSoundEvents {
    public static final SoundEvent MUSIC_DISC_FROZEN = ModSoundEvents.register("frozen");
    public static final SoundEvent FREEZE_AMBIENT = ModSoundEvents.register("freeze_ambient");
    public static final SoundEvent FREEZE_HURT = ModSoundEvents.register("freeze_hurt");
    public static final SoundEvent FREEZE_DEATH = ModSoundEvents.register("freeze_death");
    public static final SoundEvent FREEZE_SHOOT = ModSoundEvents.register("freeze_shoot");
    public static final RegistryEntry.Reference<SoundEvent> MUSIC_OVERWORLD_TUNDRA = ModSoundEvents.registerReference("tundra");
    private static SoundEvent register(String id) {
        return ModSoundEvents.register(new Identifier(id));
    }
    private static SoundEvent register(Identifier id) {
        return ModSoundEvents.register(id, id);
    }
    private static RegistryEntry.Reference<SoundEvent> registerReference(String id) {
        return ModSoundEvents.registerReference(new Identifier(id));
    }
    private static RegistryEntry.Reference<SoundEvent> registerReference(Identifier id) {
        return ModSoundEvents.registerReference(id, id);
    }
    private static SoundEvent register(Identifier id, Identifier soundId) {
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(soundId));
    }
    private static RegistryEntry.Reference<SoundEvent> registerReference(Identifier id, Identifier soundId) {
        return Registry.registerReference(Registries.SOUND_EVENT, id, SoundEvent.of(soundId));
    }
}
