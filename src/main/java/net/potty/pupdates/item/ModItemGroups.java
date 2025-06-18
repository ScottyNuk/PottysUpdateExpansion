package net.potty.pupdates.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.potty.pupdates.PottysUpdates;
import net.potty.pupdates.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup UPDATE_ITEMS_1 = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(PottysUpdates.MOD_ID, "update_items_1"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.RESIN_BRICK))
                    .displayName(Text.translatable("ItemGroup.pupdates.update_items_1"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.RESIN_BRICK);
                        entries.add(ModItems.BLUE_EGG);
                        entries.add(ModItems.BROWN_EGG);
                        entries.add(ModItems.CKINGS_HEART);
                    }).build());

    public static final ItemGroup UPDATE_BLOCKS_1 = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(PottysUpdates.MOD_ID, "update_blocks_1"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.RESIN_BRICKS))
                    .displayName(Text.translatable("ItemGroup.pupdates.update_blocks_1"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModBlocks.CREAKING_HEART);
                        entries.add(ModBlocks.DESERT_POPPY);



                        entries.add(ModBlocks.RESIN_CLUMP);
                        entries.add(ModBlocks.RESIN_BLOCK);
                        entries.add(ModBlocks.RESIN_BRICKS);
                        entries.add(ModBlocks.CHISELED_RESIN_BRICKS);

                        entries.add(ModBlocks.SHORT_DRY_GRASS);
                        entries.add(ModBlocks.TALL_DRY_GRASS);
                        entries.add(ModBlocks.FIREFLY_BUSH);
                        entries.add(ModBlocks.DEAD_FIREFLY_BUSH);
                        entries.add(ModBlocks.WILDFLOWERS);

                        entries.add(ModBlocks.CACTUS_FLOWER);


                        entries.add(ModBlocks.LEAF_LITTER);
                        entries.add(ModBlocks.DRY_LEAF_LITTER);
                        entries.add(ModBlocks.AUTUMN_LEAF_LITTER);
                        entries.add(ModBlocks.DARK_LEAF_LITTER);
                        entries.add(ModBlocks.CHERRY_LEAF_LITTER);
                        entries.add(ModBlocks.FRESH_LEAF_LITTER);
                        entries.add(ModBlocks.PALE_LEAF_LITTER);

                        entries.add(ModBlocks.DEEPSLATE_PEBBLE_PATH);
                        entries.add(ModBlocks.MOSSY_PEBBLE_PATH);
                        entries.add(ModBlocks.PEBBLE_PATH);
                        entries.add(ModBlocks.BUSH);

                        entries.add(ModBlocks.PALE_SHORT_GRASS);
                        entries.add(ModBlocks.PALE_TALL_GRASS);

                        entries.add(ModBlocks.PALE_MOSS);
                        entries.add(ModBlocks.PALE_MOSS_CARPET);
                        entries.add(ModBlocks.HANGING_PALE_MOSS);


                        entries.add(ModBlocks.PALE_OAK_LOG);
                        entries.add(ModBlocks.PALE_OAK_WOOD);
                        entries.add(ModBlocks.STRIPPED_PALE_OAK_LOG);
                        entries.add(ModBlocks.STRIPPED_PALE_OAK_WOOD);

                        entries.add(ModBlocks.PALE_OAK_SAPLING);
                        entries.add(ModBlocks.PALE_OAK_LEAVES);

                        entries.add(ModBlocks.PALE_OAK_PLANKS);
                        entries.add(ModBlocks.PALE_OAK_STAIRS);
                        entries.add(ModBlocks.PALE_OAK_SLAB);
                        entries.add(ModBlocks.PALE_OAK_FENCE);
                        entries.add(ModBlocks.PALE_OAK_FENCE_GATE);
                        entries.add(ModBlocks.PALE_OAK_TRAP_DOOR);
                        entries.add(ModBlocks.PALE_OAK_DOOR);
                        entries.add(ModBlocks.PALE_OAK_BUTTON);
                        entries.add(ModBlocks.PALE_OAK_PRESSURE_PLATE);

                        entries.add(ModBlocks.MAPLE_LOG);
                        entries.add(ModBlocks.MAPLE_WOOD);
                        entries.add(ModBlocks.STRIPPED_MAPLE_LOG);
                        entries.add(ModBlocks.STRIPPED_MAPLE_WOOD);

                        entries.add(ModBlocks.MAPLE_SAPLING);
                        entries.add(ModBlocks.MAPLE_LEAVES);
                        entries.add(ModBlocks.MAPLE_LEAVES_RED);
                        entries.add(ModBlocks.MAPLE_LEAVES_ORANGE);
                        entries.add(ModBlocks.MAPLE_LEAVES_YELLOW);

                        entries.add(ModBlocks.MAPLE_PLANKS);
                        entries.add(ModBlocks.MAPLE_STAIRS);
                        entries.add(ModBlocks.MAPLE_SLAB);
                        entries.add(ModBlocks.MAPLE_FENCE);
                        entries.add(ModBlocks.MAPLE_FENCE_GATE);
                        entries.add(ModBlocks.MAPLE_TRAP_DOOR);
                        entries.add(ModBlocks.MAPLE_DOOR);
                        entries.add(ModBlocks.AUTUMN_MAPLE_DOOR);
                        entries.add(ModBlocks.AUTUMN_MAPLE_TRAP_DOOR);
                        entries.add(ModBlocks.MAPLE_BUTTON);
                        entries.add(ModBlocks.MAPLE_PRESSURE_PLATE);


                    }).build());


    public static final ItemGroup MOD_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(PottysUpdates.MOD_ID, "mod_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.ARTIFACT))
                    .displayName(Text.translatable("MOD_ITEMS"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ARTIFACT);
                    }).build());


















    public static void registerItemGroups() {
        PottysUpdates.LOGGER.info("Registering Item Groups for " + PottysUpdates.MOD_ID);
    }
}
