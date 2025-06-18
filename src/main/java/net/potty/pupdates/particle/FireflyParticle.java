package net.potty.pupdates.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class FireflyParticle extends SpriteBillboardParticle {

    private static final float FADE_OUT_LENGTH = 0.3F;
    private static final float FADE_IN_LENGTH = 0.1F;
    private static final float RANDOM_MOTION_MAGNITUDE = 0.1F;

    FireflyParticle(ClientWorld world, double x, double y, double z, double vx, double vy, double vz) {
        super(world, x, y, z, vx, vy, vz);
        this.ascending = true;
        this.velocityMultiplier = 0.96F;
        this.scale *= 0.75F;
        this.velocityX *= 0.4F;
        this.velocityY *= 0.4F;
        this.velocityZ *= 0.4F;
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public int getBrightness(float tint) {
        float lifeProgress = getLifeProgress(this.age + tint);
        return (int) (255.0F * computeAlphaFade(lifeProgress, FADE_IN_LENGTH, FADE_OUT_LENGTH));
    }

    @Override
    public void tick() {
        super.tick();

        // Allow to pass through blocks by not checking for collision
        float alpha = computeAlphaFade(getLifeProgress(this.age), FADE_IN_LENGTH, FADE_OUT_LENGTH);
        this.setAlpha(MathHelper.clamp(alpha, 0.0F, 1.0F));

        // Occasionally apply random motion
        if (Math.random() > 0.95 || this.age == 1) {
            double dx = (Math.random() - 0.5) * RANDOM_MOTION_MAGNITUDE;
            double dy = (Math.random() - 0.5) * RANDOM_MOTION_MAGNITUDE;
            double dz = (Math.random() - 0.5) * RANDOM_MOTION_MAGNITUDE;
            this.setVelocity(dx, dy, dz);
        }
    }

    private float getLifeProgress(float age) {
        return MathHelper.clamp(age / this.maxAge, 0.0F, 1.0F);
    }

    private static float computeAlphaFade(float progress, float fadeIn, float fadeOut) {
        if (progress >= 1.0F - fadeOut) {
            return (1.0F - progress) / fadeOut;
        } else if (progress <= fadeIn) {
            return progress / fadeIn;
        } else {
            return 1.0F;
        }
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientWorld world, double x, double y, double z, double vx, double vy, double vz) {
            FireflyParticle particle = new FireflyParticle(
                    world,
                    x, y, z,
                    0.5 - world.random.nextDouble(),
                    world.random.nextBoolean() ? vy : -vy,
                    0.5 - world.random.nextDouble()
            );

            // 90% chance for 36–180 ticks, 10% chance for 36–690 ticks
            if (world.random.nextFloat() < 0.9f) {
                particle.setMaxAge(world.random.nextBetween(36, 180));
            } else {
                particle.setMaxAge(world.random.nextBetween(181, 690));
            }

            particle.scale(1.5F);
            particle.setSprite(this.spriteProvider);
            particle.setAlpha(0.0F);
            return particle;
        }
    }
}
