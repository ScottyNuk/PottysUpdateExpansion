package net.potty.pupdates.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.PlantBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.potty.pupdates.particle.ModParticles;
import net.potty.pupdates.sound.ModSounds;
import net.potty.pupdates.util.ModWorldUtil;

public class FireflyBushBlock extends PlantBlock implements Fertilizable {
    private static final double FIRE_FLY_CHANCE = 0.7;
    private static final double FIREFLY_HORIZONTAL_RADIUS = 10.0;
    private static final double FIREFLY_VERTICAL_RADIUS = 5.0;
    private static final int LIGHT_LEVEL_THRESHOLD = 13;
    private static final int IDLE_SOUND_CHANCE = 30;
    public static final MapCodec<FireflyBushBlock> CODEC = createCodec(FireflyBushBlock::new);

    public FireflyBushBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends FireflyBushBlock> getCodec() {
        return CODEC;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        long timeOfDay = world.getTimeOfDay() % 24000L;
        if (timeOfDay < 12000L) return;

        if (random.nextInt(IDLE_SOUND_CHANCE) == 0 && world.getTopY() <= pos.getY()) {
            ModWorldUtil.playSoundAtBlockCenterClient(world, pos, ModSounds.BLOCK_DEADBUSH_IDLE, SoundCategory.AMBIENT, 1.0F, 1.0F, false);
        }

        // Spawn firefly particle
        double d = pos.getX() + 0.5;
        double e = pos.getY() + 1.0;
        double f = pos.getZ() + 0.5;
        world.addParticle(ModParticles.FIREFLY, d, e, f, 0.0, 0.0, 0.0);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return false;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
    }
}
