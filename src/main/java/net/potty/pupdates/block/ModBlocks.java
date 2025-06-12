package net.potty.pupdates.block;

import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.potty.pupdates.PottysUpdates;
import net.potty.pupdates.block.custom.HangingPaleMossBlock;
import net.potty.pupdates.world.tree.ModSaplingGenerators;

import static net.minecraft.block.Blocks.*;

public class ModBlocks {

    public static final Block RESIN_BRICKS = registerBlock("resin_bricks",
            new Block(AbstractBlock.Settings.create()));

    public static final Block RESIN_BLOCK = registerBlock("resin_block",
            new Block(AbstractBlock.Settings.create()));

    public static final Block CHISELED_RESIN_BRICKS = registerBlock("chiseled_resin_bricks",
            new Block(AbstractBlock.Settings.create()));

    public static final Block PALE_MOSS = registerBlock("pale_moss",
            new MossBlock(AbstractBlock.Settings.copy(MOSS_BLOCK)));

    public static final Block PALE_MOSS_CARPET = registerBlock("pale_moss_carpet",
            new CarpetBlock(AbstractBlock.Settings.copy(MOSS_CARPET)));

    public static final Block HANGING_PALE_MOSS = registerBlock("hanging_pale_moss",
            new HangingPaleMossBlock(AbstractBlock.Settings.copy(GLOW_LICHEN)));








    //pale oak

    public static final Block PALE_OAK_LOG = registerBlock("pale_oak_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));
    public static final Block PALE_OAK_WOOD = registerBlock("pale_oak_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_PALE_OAK_LOG = registerBlock("stripped_pale_oak_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_PALE_OAK_WOOD = registerBlock("stripped_pale_oak_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)));



    public static final Block PALE_OAK_PLANKS = registerBlock("pale_oak_planks",
            new Block(AbstractBlock.Settings.copy(OAK_PLANKS)));
    public static final Block PALE_OAK_LEAVES = registerBlock("pale_oak_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(OAK_LEAVES)));

    public static final Block PALE_OAK_SAPLING = registerBlock("pale_oak_sapling",
            new SaplingBlock(ModSaplingGenerators.PALE_OAK, AbstractBlock.Settings.copy(OAK_SAPLING)));





    public static final Block PALE_OAK_STAIRS = registerBlock("pale_oak_stairs",
            new StairsBlock(ModBlocks.PALE_OAK_PLANKS.getDefaultState(),
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block PALE_OAK_SLAB = registerBlock("pale_oak_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block PALE_OAK_BUTTON = registerBlock("pale_oak_button",
            new ButtonBlock(BlockSetType.OAK, 10, AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block PALE_OAK_PRESSURE_PLATE = registerBlock("pale_oak_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block PALE_OAK_FENCE = registerBlock("pale_oak_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block PALE_OAK_FENCE_GATE = registerBlock("pale_oak_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block PALE_OAK_DOOR = registerBlock("pale_oak_door",
            new DoorBlock(BlockSetType.ACACIA, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));

    public static final Block PALE_OAK_TRAP_DOOR = registerBlock("pale_oak_trap_door",
            new TrapdoorBlock(BlockSetType.ACACIA, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));





















    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(PottysUpdates.MOD_ID, name), block);
    }
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(PottysUpdates.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }
    public static void registerModBlocks(){
        PottysUpdates.LOGGER.info("Registering Mod Blocks for " + PottysUpdates.MOD_ID);
    }
}
