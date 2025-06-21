package net.potty.pupdates.block;





import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.potty.pupdates.PottysUpdates;
import net.potty.pupdates.block.custom.*;
import net.potty.pupdates.world.tree.ModSaplingGenerators;

import static net.minecraft.block.Blocks.*;

public class ModBlocks {



    public static final Block CREAKING_HEART = registerBlock("creaking_heart",
            new CreakingHeartBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)
                    .nonOpaque()
                    .luminance(state -> state.get(CreakingHeartBlock.STATE) == HeartState.ON ? 10 : 0)
                    .ticksRandomly()));

    public static final Block RESIN_CLUMP = registerBlock("resin_clump",
            new ResinClumpBlock(AbstractBlock.Settings.copy(SLIME_BLOCK).nonOpaque().noCollision().luminance(state -> 3)));

    public static final Block UPDATE_ALTAR = registerBlock("update_altar",
            new UpdateAltarBlock(AbstractBlock.Settings.create()));



    //Leaf Litter
    public static final Block LEAF_LITTER = registerBlock("leaf_litter",
            new LeafLitterBlock(AbstractBlock.Settings.create().noCollision().sounds(BlockSoundGroup.GRASS)));

    public static final Block CHERRY_LEAF_LITTER = registerBlock("cherry_leaf_litter",
            new LeafLitterBlock(AbstractBlock.Settings.create().noCollision().sounds(BlockSoundGroup.GRASS)));

    public static final Block AUTUMN_LEAF_LITTER = registerBlock("autumn_leaf_litter",
            new LeafLitterBlock(AbstractBlock.Settings.create().noCollision().sounds(BlockSoundGroup.GRASS)));

    public static final Block DRY_LEAF_LITTER = registerBlock("dry_leaf_litter",
            new LeafLitterBlock(AbstractBlock.Settings.create().noCollision().sounds(BlockSoundGroup.GRASS)));

    public static final Block PALE_LEAF_LITTER = registerBlock("pale_leaf_litter",
            new LeafLitterBlock(AbstractBlock.Settings.create().noCollision().sounds(BlockSoundGroup.GRASS)));

    public static final Block FRESH_LEAF_LITTER = registerBlock("fresh_leaf_litter",
            new LeafLitterBlock(AbstractBlock.Settings.create().noCollision().sounds(BlockSoundGroup.GRASS)));

    public static final Block DARK_LEAF_LITTER = registerBlock("dark_leaf_litter",
            new LeafLitterBlock(AbstractBlock.Settings.create().noCollision().sounds(BlockSoundGroup.GRASS)));


    //Pebble Path

    public static final Block PEBBLE_PATH = registerBlock("pebble_path",
            new LeafLitterBlock(AbstractBlock.Settings.create().noCollision().sounds(BlockSoundGroup.STONE)));

    public static final Block MOSSY_PEBBLE_PATH = registerBlock("mossy_pebble_path",
            new LeafLitterBlock(AbstractBlock.Settings.create().noCollision().sounds(BlockSoundGroup.STONE)));

    public static final Block DEEPSLATE_PEBBLE_PATH = registerBlock("deepslate_pebble_path",
            new LeafLitterBlock(AbstractBlock.Settings.create().noCollision().sounds(BlockSoundGroup.STONE)));




    //Nature
    public static final Block TALL_DRY_GRASS = registerBlock("tall_dry_grass",
            new TallDryGrassBlock(AbstractBlock.Settings.copy(TALL_GRASS)));

    public static final Block SHORT_DRY_GRASS = registerBlock("short_dry_grass",
            new ShortDryGrassBlock(AbstractBlock.Settings.copy(SHORT_GRASS)));

    public static final Block DEAD_FIREFLY_BUSH = registerBlock("dead_firefly_bush",
            new DeadFireflyBushBlock(AbstractBlock.Settings.copy(SWEET_BERRY_BUSH)));

    public static final Block BUSH = registerBlock("bush",
            new BushBlock(AbstractBlock.Settings.copy(SWEET_BERRY_BUSH)));

    public static final Block CACTUS_FLOWER = registerBlock("cactus_flower",
            new CactusFlowerBlock(AbstractBlock.Settings
                    .create()
                    .noCollision()
                    .breakInstantly()
                    .nonOpaque()));

    public static final Block FIREFLY_BUSH = registerBlock("firefly_bush",
            new FireflyBushBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .burnable()
                    .luminance(state -> 2)
                    .noCollision()
                    .breakInstantly()
                    .ticksRandomly()
                    .nonOpaque()
                    .sounds(BlockSoundGroup.SWEET_BERRY_BUSH)
                    .pistonBehavior(PistonBehavior.DESTROY)
            ));

    public static final Block WILDFLOWERS = registerBlock("wildflowers",
            new FlowerbedBlock(
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .sounds(BlockSoundGroup.PINK_PETALS)
                    .pistonBehavior(PistonBehavior.DESTROY)
    ));



    //Blocks

    public static final Block RESIN_BRICKS = registerBlock("resin_bricks",
            new Block(AbstractBlock.Settings.create()));

    public static final Block RESIN_BLOCK = registerBlock("resin_block",
            new Block(AbstractBlock.Settings.create()));

    public static final Block CHISELED_RESIN_BRICKS = registerBlock("chiseled_resin_bricks",
            new Block(AbstractBlock.Settings.create()));




    //Pale Nature

    public static final Block PALE_SHORT_GRASS =registerBlock("pale_short_grass",
            new ModShortPlantBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .replaceable()
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .offset(AbstractBlock.OffsetType.XYZ)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block PALE_TALL_GRASS =registerBlock("pale_tall_grass",
            new ModTallPlantBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .replaceable()
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .offset(AbstractBlock.OffsetType.XZ)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)));


    public static final Block PALE_MOSS = registerBlock("pale_moss",
            new PaleMossBlock(AbstractBlock.Settings.copy(MOSS_BLOCK)));

    public static final Block PALE_MOSS_CARPET = registerBlock("pale_moss_carpet",
            new CarpetBlock(AbstractBlock.Settings.copy(MOSS_CARPET)));

    public static final Block HANGING_PALE_MOSS = registerBlock("hanging_pale_moss",
            new HangingPaleMossBlock(AbstractBlock.Settings.copy(GLOW_LICHEN)));



    //Pale Oak

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



    //Maple Blocks

    public static final Block MAPLE_LOG = registerBlock("maple_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));
    public static final Block MAPLE_WOOD = registerBlock("maple_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_MAPLE_LOG = registerBlock("stripped_maple_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_MAPLE_WOOD = registerBlock("stripped_maple_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)));



    public static final Block MAPLE_PLANKS = registerBlock("maple_planks",
            new Block(AbstractBlock.Settings.copy(OAK_PLANKS)));
    public static final Block MAPLE_LEAVES = registerBlock("maple_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(OAK_LEAVES)));
    public static final Block MAPLE_LEAVES_RED = registerBlock("maple_leaves_red",
            new LeavesBlock(AbstractBlock.Settings.copy(OAK_LEAVES)));
    public static final Block MAPLE_LEAVES_ORANGE = registerBlock("maple_leaves_orange",
            new LeavesBlock(AbstractBlock.Settings.copy(OAK_LEAVES)));
    public static final Block MAPLE_LEAVES_YELLOW = registerBlock("maple_leaves_yellow",
            new LeavesBlock(AbstractBlock.Settings.copy(OAK_LEAVES)));

    public static final Block MAPLE_SAPLING = registerBlock("maple_sapling",
            new SaplingBlock(ModSaplingGenerators.MAPLE, AbstractBlock.Settings.copy(OAK_SAPLING)));





    public static final Block MAPLE_STAIRS = registerBlock("maple_stairs",
            new StairsBlock(ModBlocks.PALE_OAK_PLANKS.getDefaultState(),
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block MAPLE_SLAB = registerBlock("maple_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block MAPLE_BUTTON = registerBlock("maple_button",
            new ButtonBlock(BlockSetType.OAK, 10, AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block MAPLE_PRESSURE_PLATE = registerBlock("maple_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block MAPLE_FENCE = registerBlock("maple_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block MAPLE_FENCE_GATE = registerBlock("maple_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block MAPLE_DOOR = registerBlock("maple_door",
            new DoorBlock(BlockSetType.ACACIA, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));

    public static final Block MAPLE_TRAP_DOOR = registerBlock("maple_trap_door",
            new TrapdoorBlock(BlockSetType.ACACIA, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));

    public static final Block AUTUMN_MAPLE_DOOR = registerBlock("autumn_maple_door",
            new DoorBlock(BlockSetType.ACACIA, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));

    public static final Block AUTUMN_MAPLE_TRAP_DOOR = registerBlock("autumn_maple_trap_door",
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
