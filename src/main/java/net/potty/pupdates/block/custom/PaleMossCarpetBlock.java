package net.potty.pupdates.block.custom;


import net.minecraft.block.Blocks;
import net.minecraft.block.CarpetBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.sound.BlockSoundGroup;

public class PaleMossCarpetBlock extends CarpetBlock {
    public PaleMossCarpetBlock() {
        super(AbstractBlock.Settings
                .copy(Blocks.MOSS_CARPET)
                .sounds(BlockSoundGroup.MOSS_CARPET)
        );
    }
}
