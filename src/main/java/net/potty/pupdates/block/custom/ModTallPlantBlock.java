package net.potty.pupdates.block.custom;


import net.minecraft.block.BlockState;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.potty.pupdates.block.ModBlocks;

public class ModTallPlantBlock extends TallPlantBlock {
    public ModTallPlantBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(ModBlocks.PALE_MOSS) || super.canPlantOnTop(floor, world, pos);
    }
}
