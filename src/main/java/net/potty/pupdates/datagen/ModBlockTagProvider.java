package net.potty.pupdates.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.potty.pupdates.block.ModBlocks;
import net.potty.pupdates.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {


        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(ModBlocks.PALE_OAK_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.PALE_OAK_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(ModBlocks.MAPLE_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.MAPLE_FENCE_GATE);


        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.PALE_OAK_LOG)
                .add(ModBlocks.STRIPPED_PALE_OAK_LOG)
                .add(ModBlocks.PALE_OAK_WOOD)
                .add(ModBlocks.STRIPPED_PALE_OAK_WOOD)
                .add(ModBlocks.MAPLE_LOG)
                .add(ModBlocks.STRIPPED_MAPLE_LOG)
                .add(ModBlocks.MAPLE_WOOD)
                .add(ModBlocks.STRIPPED_MAPLE_WOOD);



        getOrCreateTagBuilder(ModTags.Blocks.DRY_VEGETATION_MAY_PLACE_ON)
                .add(Blocks.SAND)
                .add(Blocks.RED_SAND)
                .add(Blocks.TERRACOTTA)
                .add(Blocks.DIRT)
                .add(Blocks.FARMLAND);


        this.getOrCreateTagBuilder(ModTags.Blocks.PLAYS_AMBIENT_DESERT_BLOCK_SOUNDS)
                .add(Blocks.SAND, Blocks.RED_SAND, Blocks.TERRACOTTA);

    }
}
