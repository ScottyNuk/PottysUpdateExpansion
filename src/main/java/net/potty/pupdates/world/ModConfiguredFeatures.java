package net.potty.pupdates.world;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.ThreeLayersFeatureSize;
import net.minecraft.world.gen.foliage.DarkOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.DarkOakTrunkPlacer;
import net.potty.pupdates.PottysUpdates;
import net.potty.pupdates.block.ModBlocks;
import net.potty.pupdates.util.ModTags;

import java.util.OptionalInt;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> DRY_DESSERT_BONEMEAL = registerKey("dry_dessert_bonemeal");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DRY_DESSERT_VEGETATION = registerKey("dry_dessert_vegetation");

    public static final RegistryKey<ConfiguredFeature<?, ?>> PALE_OAK_KEY = registerKey("pale_oak");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PALE_MOSS_PATCH_BONEMEAL = registerKey("pale_moss_patch_bonemeal");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PALE_MOSS_VEGETATION = registerKey("pale_moss_vegetation");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MAPLE_KEY = registerKey("maple");

    public static final RegistryKey<ConfiguredFeature<?, ?>> MAPLE_RED_KEY = registerKey("maple_red");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MAPLE_ORANGE_KEY = registerKey("maple_orange");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MAPLE_YELLOW_KEY = registerKey("maple_yellow");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MAPLE_RANDOM_KEY = registerKey("maple_random");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        // Get registry lookups early — must be before usage!
        var configuredFeatureLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        var placedFeatureLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        // Dry Dessert Vegetation (Random Patch of tall grass, short grass, dead bush)
        register(context,
                DRY_DESSERT_VEGETATION,
                Feature.RANDOM_PATCH,
                new RandomPatchFeatureConfig(
                        10, 2, 2,
                        PlacedFeatures.createEntry(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockFeatureConfig(
                                        new WeightedBlockStateProvider(
                                                DataPool.<BlockState>builder()
                                                        .add(ModBlocks.TALL_DRY_GRASS.getDefaultState(), 25)
                                                        .add(ModBlocks.SHORT_DRY_GRASS.getDefaultState(), 50)
                                                        .add(Blocks.DEAD_BUSH.getDefaultState(), 9)
                                                        .add(Blocks.CACTUS.getDefaultState(), 1)
                                        )
                                )
                        )
                )
        );

        // Dry Dessert Bonemeal feature triggers the vegetation feature above
        register(context,
                DRY_DESSERT_BONEMEAL,
                Feature.VEGETATION_PATCH,
                new VegetationPatchFeatureConfig(
                        ModTags.Blocks.DRY_VEGETATION_MAY_PLACE_ON,              // Tag for valid blocks to place on
                        BlockStateProvider.of(Blocks.SAND),               // Block to place (dry dirt)
                        PlacedFeatures.createEntry(configuredFeatureLookup.getOrThrow(DRY_DESSERT_VEGETATION)), // linked vegetation feature
                        VerticalSurfaceType.FLOOR,
                        ConstantIntProvider.create(1),
                        0.0F,
                        5,
                        0.5F,
                        UniformIntProvider.create(1, 2),
                        0.5F
                )
        );

        // Pale Oak Tree
        register(context, PALE_OAK_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.PALE_OAK_LOG),
                new DarkOakTrunkPlacer(6, 2, 1),
                BlockStateProvider.of(ModBlocks.PALE_OAK_LEAVES),
                new DarkOakFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0)),
                new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())
        ).ignoreVines().build());

        // Pale Moss Vegetation
        register(context,
                PALE_MOSS_VEGETATION,
                Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(
                        new WeightedBlockStateProvider(
                                DataPool.<BlockState>builder()
                                        .add(ModBlocks.PALE_MOSS_CARPET.getDefaultState(), 25)
                                        .add(ModBlocks.PALE_SHORT_GRASS.getDefaultState(), 50)
                                        .add(ModBlocks.PALE_TALL_GRASS.getDefaultState(), 10)
                        )
                )
        );

        // Pale Moss Patch Bonemeal
        register(context, PALE_MOSS_PATCH_BONEMEAL, Feature.VEGETATION_PATCH,
                new VegetationPatchFeatureConfig(
                        BlockTags.MOSS_REPLACEABLE,
                        BlockStateProvider.of(ModBlocks.PALE_MOSS),
                        PlacedFeatures.createEntry(configuredFeatureLookup.getOrThrow(PALE_MOSS_VEGETATION)),
                        VerticalSurfaceType.FLOOR,
                        ConstantIntProvider.create(1),
                        0.0F,
                        5,
                        0.6F,
                        UniformIntProvider.create(1, 2),
                        0.75F
                )
        );

        // Maple Trees (normal + colors)
        register(context, MAPLE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.MAPLE_LOG),
                new DarkOakTrunkPlacer(7, 3, 2),
                BlockStateProvider.of(ModBlocks.MAPLE_LEAVES),
                new DarkOakFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0)),
                new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())
        ).ignoreVines().build());

        register(context, MAPLE_RED_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.MAPLE_LOG),
                new DarkOakTrunkPlacer(7, 3, 2),
                BlockStateProvider.of(ModBlocks.MAPLE_LEAVES_RED),
                new DarkOakFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0)),
                new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())
        ).ignoreVines().build());

        register(context, MAPLE_ORANGE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.MAPLE_LOG),
                new DarkOakTrunkPlacer(7, 3, 2),
                BlockStateProvider.of(ModBlocks.MAPLE_LEAVES_ORANGE),
                new DarkOakFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0)),
                new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())
        ).ignoreVines().build());

        register(context, MAPLE_YELLOW_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.MAPLE_LOG),
                new DarkOakTrunkPlacer(7, 3, 2),
                BlockStateProvider.of(ModBlocks.MAPLE_LEAVES_YELLOW),
                new DarkOakFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0)),
                new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())
        ).ignoreVines().build());

        // Maple random selector feature that picks a random maple tree variant
        var mapleRedPlaced = placedFeatureLookup.getOrThrow(ModPlacedFeatures.MAPLE_RED_PLACED_KEY);
        var mapleOrangePlaced = placedFeatureLookup.getOrThrow(ModPlacedFeatures.MAPLE_ORANGE_PLACED_KEY);
        var mapleYellowPlaced = placedFeatureLookup.getOrThrow(ModPlacedFeatures.MAPLE_YELLOW_PLACED_KEY);
        var mapleNormalPlaced = placedFeatureLookup.getOrThrow(ModPlacedFeatures.MAPLE_PLACED_KEY);

        register(context, MAPLE_RANDOM_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(
                        ImmutableList.of(
                                new RandomFeatureEntry(mapleRedPlaced, 0.3333f),
                                new RandomFeatureEntry(mapleOrangePlaced, 0.3333f),
                                new RandomFeatureEntry(mapleYellowPlaced, 0.3333f),
                                new RandomFeatureEntry(mapleNormalPlaced, 0.01f)
                        ),
                        mapleYellowPlaced
                )
        );
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(PottysUpdates.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
