package almer.snowyandfrosty.blocks.impl;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public record ModWoodType(String name, BlockSetType setType, BlockSoundGroup soundType, BlockSoundGroup hangingSignSoundType, SoundEvent fenceGateClose, SoundEvent fenceGateOpen) {
    private static final Map<String, WoodType> VALUES = new Object2ObjectArrayMap();
    public static final Codec<WoodType> CODEC;
    public static final WoodType WILLOW;
    public ModWoodType(String name, BlockSetType setType) {
        this(name, setType, BlockSoundGroup.WOOD, BlockSoundGroup.HANGING_SIGN, SoundEvents.BLOCK_FENCE_GATE_CLOSE, SoundEvents.BLOCK_FENCE_GATE_OPEN);
    }

    public ModWoodType(String name, BlockSetType setType, BlockSoundGroup soundType, BlockSoundGroup hangingSignSoundType, SoundEvent fenceGateClose, SoundEvent fenceGateOpen) {
        this.name = name;
        this.setType = setType;
        this.soundType = soundType;
        this.hangingSignSoundType = hangingSignSoundType;
        this.fenceGateClose = fenceGateClose;
        this.fenceGateOpen = fenceGateOpen;
    }

    private static WoodType register(WoodType type) {
        VALUES.put(type.name(), type);
        return type;
    }

    public static Stream<WoodType> stream() {
        return VALUES.values().stream();
    }

    public String name() {
        return this.name;
    }

    public BlockSetType setType() {
        return this.setType;
    }

    public BlockSoundGroup soundType() {
        return this.soundType;
    }

    public BlockSoundGroup hangingSignSoundType() {
        return this.hangingSignSoundType;
    }

    public SoundEvent fenceGateClose() {
        return this.fenceGateClose;
    }

    public SoundEvent fenceGateOpen() {
        return this.fenceGateOpen;
    }
    static {
        Objects.requireNonNull(VALUES);
        CODEC = WoodType.CODEC;
        WILLOW = register(new WoodType("willow", ModBlockSetType.WILLOW));
    }
}
