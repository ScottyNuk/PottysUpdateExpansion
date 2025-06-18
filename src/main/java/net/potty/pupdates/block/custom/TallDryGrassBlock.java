package net.potty.pupdates.block.custom;

import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.potty.pupdates.block.ModBlocks;

public class TallDryGrassBlock extends Block implements Fertilizable {
    private static final VoxelShape SHAPE = createColumnShape(14.0, 0.0, 16.0);

    public TallDryGrassBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    // Copied from vanilla method to create a column-shaped VoxelShape
    public static VoxelShape createColumnShape(double sizeXz, double minY, double maxY) {
        return createColumnShape(sizeXz, sizeXz, minY, maxY);
    }

    public static VoxelShape createColumnShape(double sizeX, double sizeZ, double minY, double maxY) {
        double d = sizeX / 2.0;
        double e = sizeZ / 2.0;
        return Block.createCuboidShape(8.0 - d, minY, 8.0 - e, 8.0 + d, maxY, 8.0 + e);
    }

    private boolean canSpreadTo(WorldView world, BlockPos pos) {
        BlockPos below = pos.down();
        BlockState blockBelow = world.getBlockState(below);
        BlockState blockAt = world.getBlockState(pos);

        return blockAt.isAir() && blockBelow.isOpaque() && !blockAt.getFluidState().isStill();
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        for (Direction direction : Direction.Type.HORIZONTAL) {
            BlockPos offset = pos.offset(direction);
            if (canSpreadTo(world, offset)) return true;
        }
        return false;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        for (int i = 0; i < 4; i++) {
            BlockPos offset = pos.add(random.nextBetween(-1, 2), 0, random.nextBetween(-1, 2));
            if (canSpreadTo(world, offset)) {
                world.setBlockState(offset, ModBlocks.SHORT_DRY_GRASS.getDefaultState());
            }
        }
    }

    // 🛠️ Makes the block break if the block below is gone
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isOpaque();
    }

    @Override
    public BlockState getStateForNeighborUpdate(
            BlockState state,
            Direction direction,
            BlockState neighborState,
            WorldAccess world,
            BlockPos pos,
            BlockPos neighborPos
    ) {
        if (direction == Direction.DOWN && !this.canPlaceAt(state, world, pos)) {
            return Blocks.AIR.getDefaultState();
        }
        return state;
    }
}
