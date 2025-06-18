package net.potty.pupdates.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class LeafLitterBlock extends PlantBlock {
    public static final IntProperty SEGMENT_AMOUNT = IntProperty.of("segment_amount", 1, 4);
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;

    public LeafLitterBlock(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState()
                .with(SEGMENT_AMOUNT, 1)
                .with(FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<? extends PlantBlock> getCodec() {
        return createCodec(LeafLitterBlock::new);
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        return context.getStack().isOf(this.asItem())
                && state.getBlock() == this
                && state.get(SEGMENT_AMOUNT) < 4;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState existing = ctx.getWorld().getBlockState(ctx.getBlockPos());
        if (existing.getBlock() == this) {
            int amount = existing.get(SEGMENT_AMOUNT);
            if (amount < 4) {
                return existing.with(SEGMENT_AMOUNT, amount + 1);
            }
        }
        return this.getDefaultState()
                .with(FACING, ctx.getHorizontalPlayerFacing())
                .with(SEGMENT_AMOUNT, 1);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(SEGMENT_AMOUNT, FACING);
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos below = pos.down();
        return world.getBlockState(below).isSideSolidFullSquare(world, below, Direction.UP);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0, 0, 0, 1, 1.0F / 16.0F, 1); // Flat shape, 1 pixel tall
    }
}
