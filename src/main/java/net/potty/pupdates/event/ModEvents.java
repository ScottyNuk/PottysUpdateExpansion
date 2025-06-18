package net.potty.pupdates.event;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.potty.pupdates.block.ModBlocks;
import net.potty.pupdates.world.ModConfiguredFeatures;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class ModEvents {
    public static void registerModEvents() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            BlockPos pos = hitResult.getBlockPos();
            BlockState state = world.getBlockState(pos);
            ItemStack stack = player.getStackInHand(hand);

            if (!world.isClient && stack.isOf(Items.BONE_MEAL)) {
                ServerWorld serverWorld = (ServerWorld) world;
                Random random = Random.create();

                // 🌵 Cactus + Bone Meal
                if (state.isOf(Blocks.CACTUS)) {
                    BlockPos above = pos.up();

                    if (world.getBlockState(above).isAir() &&
                            ModBlocks.CACTUS_FLOWER.getDefaultState().canPlaceAt(world, above)) {

                        world.setBlockState(above, ModBlocks.CACTUS_FLOWER.getDefaultState(), 3);

                        serverWorld.spawnParticles(
                                ParticleTypes.HAPPY_VILLAGER,
                                above.getX() + 0.5,
                                above.getY() + 0.5,
                                above.getZ() + 0.5,
                                8, 0.3, 0.5, 0.3, 0.05
                        );

                        world.playSound(null, above, SoundEvents.BLOCK_GRASS_PLACE, SoundCategory.BLOCKS, 0.8f, 1.2f);

                        if (!player.isCreative()) {
                            stack.decrement(1);
                        }

                        return ActionResult.SUCCESS;
                    }
                }

                // 🪨 Sand or Red Sand + Bone Meal triggers DRY_DESSERT_BONEMEAL vegetation patch
                if (state.isOf(Blocks.SAND) || state.isOf(Blocks.RED_SAND)) {
                    BlockPos target = pos.up();

                    RegistryWrapper.WrapperLookup lookup = serverWorld.getRegistryManager();
                    lookup.getOptionalWrapper(RegistryKeys.CONFIGURED_FEATURE)
                            .flatMap(reg -> reg.getOptional(ModConfiguredFeatures.DRY_DESSERT_BONEMEAL))
                            .ifPresent(entry -> {
                                ConfiguredFeature<?, ?> feature = entry.value();

                                // VegetationPatchFeature placement
                                feature.generate(serverWorld, serverWorld.getChunkManager().getChunkGenerator(), random, target);

                                // Particle + Sound
                                serverWorld.spawnParticles(
                                        ParticleTypes.COMPOSTER,
                                        target.getX() + 0.5,
                                        target.getY() + 0.5,
                                        target.getZ() + 0.5,
                                        8, 0.3, 0.5, 0.3, 0.05
                                );
                                world.playSound(null, target, SoundEvents.BLOCK_GRAVEL_BREAK, SoundCategory.BLOCKS, 0.8f, 1.0f);
                            });

                    if (!player.isCreative()) {
                        stack.decrement(1);
                    }

                    return ActionResult.SUCCESS;
                }
            }

            return ActionResult.PASS;
        });
    }
}
