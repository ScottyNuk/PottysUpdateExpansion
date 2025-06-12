package net.potty.pupdates.world;

import com.google.common.collect.ImmutableList;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.ThreeLayersFeatureSize;
import net.minecraft.world.gen.foliage.DarkOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.DarkOakTrunkPlacer;
import net.potty.pupdates.PottysUpdates;
import net.potty.pupdates.block.ModBlocks;

import java.util.OptionalInt;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>>PALE_OAK_KEY = registerKey("pale_oak");





    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        register(context, PALE_OAK_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.PALE_OAK_LOG),
                new DarkOakTrunkPlacer(6, 2, 1),

                BlockStateProvider.of(ModBlocks.PALE_OAK_LEAVES),
                new DarkOakFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0)),
                new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())
                ).ignoreVines().build()
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
