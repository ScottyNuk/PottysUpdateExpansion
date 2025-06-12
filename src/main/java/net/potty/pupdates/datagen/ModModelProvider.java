package net.potty.pupdates.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TexturedModel;
import net.potty.pupdates.block.ModBlocks;
import net.potty.pupdates.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        BlockStateModelGenerator.BlockTexturePool paleOakPool = blockStateModelGenerator
                .registerCubeAllModelTexturePool(ModBlocks.PALE_OAK_PLANKS);


        paleOakPool.stairs(ModBlocks.PALE_OAK_STAIRS);
        paleOakPool.slab(ModBlocks.PALE_OAK_SLAB);
        paleOakPool.button(ModBlocks.PALE_OAK_BUTTON);
        paleOakPool.pressurePlate(ModBlocks.PALE_OAK_PRESSURE_PLATE);
        paleOakPool.fence(ModBlocks.PALE_OAK_FENCE);
        paleOakPool.fenceGate(ModBlocks.PALE_OAK_FENCE_GATE);

        blockStateModelGenerator.registerLog(ModBlocks.PALE_OAK_LOG).log(ModBlocks.PALE_OAK_LOG).wood(ModBlocks.PALE_OAK_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_PALE_OAK_LOG).log(ModBlocks.STRIPPED_PALE_OAK_LOG).wood(ModBlocks.STRIPPED_PALE_OAK_WOOD);

        blockStateModelGenerator.registerSingleton(ModBlocks.PALE_OAK_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.PALE_OAK_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);


        blockStateModelGenerator.registerDoor(ModBlocks.PALE_OAK_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.PALE_OAK_TRAP_DOOR);




        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RESIN_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_RESIN_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RESIN_BLOCK);


    }


    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.RESIN_CLUMP, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUE_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.BROWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.ARTIFACT, Models.GENERATED);

    }
}
