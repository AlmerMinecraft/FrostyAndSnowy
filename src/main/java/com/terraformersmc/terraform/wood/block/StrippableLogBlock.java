package com.terraformersmc.terraform.wood.block;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.PillarBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.Direction;

import java.util.function.Supplier;

@Deprecated(forRemoval = true, since = "6.1.0")
public class StrippableLogBlock extends PillarBlock {
    public StrippableLogBlock(Supplier<Block> stripped, MapColor top, Settings settings) {
        super(settings);

        if (stripped != null) {
            StrippableBlockRegistry.register(this, stripped.get());
        }
    }

    /**
     * Use {@code PillarLogHelper.of(color) } instead.
     *
     * @param color Map color for all faces of log
     * @return New PillarBlock
     */
    public static PillarBlock of(MapColor color) {
        return new PillarBlock(AbstractBlock.Settings.create()
                .mapColor(color)
                .strength(2.0F)
                .sounds(BlockSoundGroup.WOOD)
                .burnable()
        );
    }

    /**
     * Use {@code PillarLogHelper.of(woodColor, barkColor) } instead.
     *
     * @param wood Map color for non-bark faces of log (ends)
     * @param bark Map color for bark faces of log (sides)
     * @return New PillarBlock
     */
    public static PillarBlock of(MapColor wood, MapColor bark) {
        return new PillarBlock(AbstractBlock.Settings.create()
                .mapColor((state) -> Direction.Axis.Y.equals(state.get(PillarBlock.AXIS)) ? wood : bark)
                .strength(2.0F)
                .sounds(BlockSoundGroup.WOOD)
                .burnable()
        );
    }
}
