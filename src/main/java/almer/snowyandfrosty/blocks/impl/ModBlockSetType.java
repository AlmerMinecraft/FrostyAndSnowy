package almer.snowyandfrosty.blocks.impl;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.block.BlockSetType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public record ModBlockSetType(String name, boolean canOpenByHand, boolean canOpenByWindCharge, boolean canButtonBeActivatedByArrows, ModBlockSetType.ActivationRule pressurePlateSensitivity, BlockSoundGroup soundType, SoundEvent doorClose, SoundEvent doorOpen, SoundEvent trapdoorClose, SoundEvent trapdoorOpen, SoundEvent pressurePlateClickOff, SoundEvent pressurePlateClickOn, SoundEvent buttonClickOff, SoundEvent buttonClickOn) {
    private static final Map<String, ModBlockSetType> VALUES = new Object2ObjectArrayMap();
    public static final Codec<BlockSetType> CODEC;
    public static final BlockSetType WILLOW;
    public ModBlockSetType(String name) {
        this(name, true, true, true, ModBlockSetType.ActivationRule.EVERYTHING, BlockSoundGroup.WOOD, SoundEvents.BLOCK_WOODEN_DOOR_CLOSE, SoundEvents.BLOCK_WOODEN_DOOR_OPEN, SoundEvents.BLOCK_WOODEN_TRAPDOOR_CLOSE, SoundEvents.BLOCK_WOODEN_TRAPDOOR_OPEN, SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_ON, SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_OFF, SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON);
    }
    public ModBlockSetType(String name, boolean canOpenByHand, boolean canOpenByWindCharge, boolean canButtonBeActivatedByArrows, ModBlockSetType.ActivationRule pressurePlateSensitivity, BlockSoundGroup soundType, SoundEvent doorClose, SoundEvent doorOpen, SoundEvent trapdoorClose, SoundEvent trapdoorOpen, SoundEvent pressurePlateClickOff, SoundEvent pressurePlateClickOn, SoundEvent buttonClickOff, SoundEvent buttonClickOn) {
        this.name = name;
        this.canOpenByHand = canOpenByHand;
        this.canOpenByWindCharge = canOpenByWindCharge;
        this.canButtonBeActivatedByArrows = canButtonBeActivatedByArrows;
        this.pressurePlateSensitivity = pressurePlateSensitivity;
        this.soundType = soundType;
        this.doorClose = doorClose;
        this.doorOpen = doorOpen;
        this.trapdoorClose = trapdoorClose;
        this.trapdoorOpen = trapdoorOpen;
        this.pressurePlateClickOff = pressurePlateClickOff;
        this.pressurePlateClickOn = pressurePlateClickOn;
        this.buttonClickOff = buttonClickOff;
        this.buttonClickOn = buttonClickOn;
    }
    private static BlockSetType register(BlockSetType blockSetType, ModBlockSetType modBlockSetType) {
        VALUES.put(modBlockSetType.name, modBlockSetType);
        return blockSetType;
    }
    public static Stream<ModBlockSetType> stream() {
        return VALUES.values().stream();
    }
    public String name() {
        return this.name;
    }
    public boolean canOpenByHand() {
        return this.canOpenByHand;
    }
    public boolean canOpenByWindCharge() {
        return this.canOpenByWindCharge;
    }
    public boolean canButtonBeActivatedByArrows() {
        return this.canButtonBeActivatedByArrows;
    }
    public ModBlockSetType.ActivationRule pressurePlateSensitivity() {
        return this.pressurePlateSensitivity;
    }
    public BlockSoundGroup soundType() {
        return this.soundType;
    }
    public SoundEvent doorClose() {
        return this.doorClose;
    }
    public SoundEvent doorOpen() {
        return this.doorOpen;
    }
    public SoundEvent trapdoorClose() {
        return this.trapdoorClose;
    }
    public SoundEvent trapdoorOpen() {
        return this.trapdoorOpen;
    }
    public SoundEvent pressurePlateClickOff() {
        return this.pressurePlateClickOff;
    }
    public SoundEvent pressurePlateClickOn() {
        return this.pressurePlateClickOn;
    }
    public SoundEvent buttonClickOff() {
        return this.buttonClickOff;
    }
    public SoundEvent buttonClickOn() {
        return this.buttonClickOn;
    }
    static {
        Objects.requireNonNull(VALUES);
        CODEC = BlockSetType.CODEC;
        WILLOW = register(new BlockSetType("willow"), new ModBlockSetType("willow"));
    }
    public static enum ActivationRule {
        EVERYTHING,
        MOBS;
        private ActivationRule() {
        }
    }
}
