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
                        entries.add(ModItems.RESIN_CLUMP);
                        entries.add(ModItems.BLUE_EGG);
                        entries.add(ModItems.BROWN_EGG);
                    }).build());

    public static final ItemGroup UPDATE_BLOCKS_1 = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(PottysUpdates.MOD_ID, "update_blocks_1"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.RESIN_BRICKS))
                    .displayName(Text.translatable("ItemGroup.pupdates.update_blocks_1"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.RESIN_BLOCK);
                        entries.add(ModBlocks.RESIN_BRICKS);
                        entries.add(ModBlocks.CHISELED_RESIN_BRICKS);


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
