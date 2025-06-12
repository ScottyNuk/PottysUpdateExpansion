package net.potty.pupdates.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import net.potty.pupdates.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

        addDrop(ModBlocks.PALE_OAK_PLANKS);
        addDrop(ModBlocks.PALE_OAK_STAIRS);
        addDrop(ModBlocks.PALE_OAK_SLAB, slabDrops(ModBlocks.PALE_OAK_SLAB));
        addDrop(ModBlocks.PALE_OAK_BUTTON);
        addDrop(ModBlocks.PALE_OAK_PRESSURE_PLATE);
        addDrop(ModBlocks.PALE_OAK_FENCE);
        addDrop(ModBlocks.PALE_OAK_FENCE_GATE);
        addDrop(ModBlocks.PALE_OAK_TRAP_DOOR);
        addDrop(ModBlocks.PALE_OAK_DOOR, doorDrops(ModBlocks.PALE_OAK_DOOR));

        addDrop(ModBlocks.PALE_OAK_LOG);
        addDrop(ModBlocks.STRIPPED_PALE_OAK_LOG);
        addDrop(ModBlocks.PALE_OAK_WOOD);
        addDrop(ModBlocks.STRIPPED_PALE_OAK_WOOD);

        addDrop(ModBlocks.PALE_OAK_SAPLING);
        addDrop(ModBlocks.PALE_OAK_LEAVES, leavesDrops(ModBlocks.PALE_OAK_LEAVES, ModBlocks.PALE_OAK_SAPLING, 0.0625f));

    }
}
