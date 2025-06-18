package net.potty.pupdates.block.custom;

import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.potty.pupdates.block.ModBlock;

public class HangingPaleMossBlock extends Block implements Fertilizable {
    public static final BooleanProperty TIP = BooleanProperty.of("tip");

    private static final VoxelShape SHAPE = ModBlock.createColumnShape(14.0, 0.0, 16.0);
    private static final VoxelShape TIP_SHAPE = ModBlock.createColumnShape(14.0, 2.0, 16.0);

    public HangingPaleMossBlock(Settings settings) {
        super(settings
                .nonOpaque()
                .noCollision()
                .ticksRandomly());
        setDefaultState(this.getDefaultState().with(TIP, true));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TIP);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(TIP) ? TIP_SHAPE : SHAPE;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState above = world.getBlockState(pos.up());
        return above.isSideSolidFullSquare(world, pos.up(), Direction.DOWN)
                || above.isOf(this);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState,
                                                WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!this.canPlaceAt(state, world, pos)) {
            world.scheduleBlockTick(pos, this, 1);
        }
        return state.with(TIP, !world.getBlockState(pos.down()).isOf(this));
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!this.canPlaceAt(state, world, pos)) {
            world.breakBlock(pos, true);
        }
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        BlockPos tip = getTipPos(world, pos);
        return world.getBlockState(tip.down()).isAir();
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        BlockPos tip = getTipPos(world, pos).down();
        if (world.getBlockState(tip).isAir()) {
            world.setBlockState(tip, state.with(TIP, true));
        }
    }

    private BlockPos getTipPos(BlockView world, BlockPos pos) {
        BlockPos.Mutable mutable = pos.mutableCopy();
        while (world.getBlockState(mutable).isOf(this)) {
            mutable.move(Direction.DOWN);
        }
        return mutable.offset(Direction.UP).toImmutable();
    }

}
