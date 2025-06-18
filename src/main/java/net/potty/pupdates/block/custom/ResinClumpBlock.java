package net.potty.pupdates.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.LichenGrower;
import net.minecraft.block.MultifaceGrowthBlock;
import net.minecraft.block.AbstractBlock;

public class ResinClumpBlock extends MultifaceGrowthBlock {
    public ResinClumpBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends MultifaceGrowthBlock> getCodec() {
        return null;
    }

    @Override
    public LichenGrower getGrower() {
        return null;
    }
}
