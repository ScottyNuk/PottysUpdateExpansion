package net.potty.pupdates.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MultifaceGrowthBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.potty.pupdates.block.ModBlocks;
import net.potty.pupdates.sound.ModSounds;

public class CreakingHeartBlock extends Block {
    public static final EnumProperty<HeartState> STATE = EnumProperty.of("state", HeartState.class);

    public CreakingHeartBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(STATE, HeartState.OFF));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(STATE);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        World world = ctx.getWorld();
        BlockPos below = ctx.getBlockPos().down();
        BlockState belowState = world.getBlockState(below);

        if (belowState.isOf(ModBlocks.PALE_OAK_LOG)) {
            return this.getDefaultState().with(STATE, isNight(world) ? HeartState.ON : HeartState.DORMANT);
        }

        return this.getDefaultState().with(STATE, HeartState.OFF);
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!world.isClient) {
            world.scheduleBlockTick(pos, this, 20);
        }
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockPos below = pos.down();
        BlockState belowState = world.getBlockState(below);

        HeartState newState = HeartState.OFF;
        if (belowState.isOf(ModBlocks.PALE_OAK_LOG)) {
            newState = isNight(world) ? HeartState.ON : HeartState.DORMANT;
        }

        if (state.get(STATE) != newState) {
            world.setBlockState(pos, state.with(STATE, newState), Block.NOTIFY_LISTENERS);
        }

        // Spawn resin clumps if the heart is ON
        if (newState == HeartState.ON && random.nextInt(4) == 0) {
            tryPlaceResinClump(world, pos, random);
        }

        world.scheduleBlockTick(pos, this, 20);
    }

    private void tryPlaceResinClump(ServerWorld world, BlockPos centerPos, Random random) {
        for (BlockPos targetPos : BlockPos.iterateOutwards(centerPos, 2, 2, 2)) {
            BlockState targetState = world.getBlockState(targetPos);
            if (targetState.isOf(ModBlocks.PALE_OAK_LOG) || targetState.isOf(ModBlocks.PALE_OAK_LEAVES)) {
                for (Direction direction : Direction.values()) {
                    BlockPos attachPos = targetPos.offset(direction);
                    if (world.getBlockState(attachPos).isReplaceable()) {
                        BlockState resinState = ModBlocks.RESIN_CLUMP
                                .getDefaultState()
                                .with(MultifaceGrowthBlock.getProperty(direction.getOpposite()), true);

                        if (resinState.canPlaceAt(world, attachPos)) {
                            world.setBlockState(attachPos, resinState, Block.NOTIFY_LISTENERS);
                            return; // only place one per tick
                        }
                    }
                }
            }
        }
    }

    private boolean isNight(World world) {
        long time = world.getTimeOfDay() % 24000L;
        return time >= 13000L && time <= 23000L;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (state.get(STATE) != HeartState.ON) return;
        long time = world.getTimeOfDay() % 24000L;
        if (time < 13000L) return;

        if (random.nextInt(20) == 0) {
            world.playSound(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    ModSounds.BLOCK_DEADBUSH_IDLE,
                    SoundCategory.AMBIENT,
                    1.0F, 1.0F,
                    false
            );
        }
    }
}
