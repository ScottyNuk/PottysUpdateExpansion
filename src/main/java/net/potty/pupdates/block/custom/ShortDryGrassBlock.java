package net.potty.pupdates.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.ShapeContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.potty.pupdates.block.ModBlock;
import net.potty.pupdates.block.ModBlocks;

public class ShortDryGrassBlock extends DryVegetationBlock implements Fertilizable {
    public static final MapCodec<ShortDryGrassBlock> CODEC = createCodec(ShortDryGrassBlock::new);
    private static final VoxelShape SHAPE = ModBlock.createColumnShape(12.0, 0.0, 10.0);

    @Override
    public MapCodec<ShortDryGrassBlock> getCodec() {
        return CODEC;
    }

    public ShortDryGrassBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        world.setBlockState(pos, ModBlocks.TALL_DRY_GRASS.getDefaultState());
    }
}
