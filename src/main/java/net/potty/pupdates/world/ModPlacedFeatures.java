package net.potty.pupdates.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.potty.pupdates.PottysUpdates;
import net.potty.pupdates.block.ModBlocks;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> MAPLE_RED_PLACED_KEY = registerKey("maple_red");
    public static final RegistryKey<PlacedFeature> MAPLE_ORANGE_PLACED_KEY = registerKey("maple_orange");
    public static final RegistryKey<PlacedFeature> MAPLE_YELLOW_PLACED_KEY = registerKey("maple_yellow");
    public static final RegistryKey<PlacedFeature> MAPLE_PLACED_KEY = registerKey("maple");
    public static final RegistryKey<PlacedFeature> MAPLE_RANDOM_PLACED_KEY = registerKey("maple_random");


    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, MAPLE_RED_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.MAPLE_RED_KEY));
        register(context, MAPLE_ORANGE_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.MAPLE_ORANGE_KEY));
        register(context, MAPLE_YELLOW_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.MAPLE_YELLOW_KEY));
        register(context, MAPLE_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.MAPLE_KEY));

        register(context, MAPLE_RANDOM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MAPLE_RANDOM_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(16, 1, 2), ModBlocks.MAPLE_SAPLING));

    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(PottysUpdates.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context,
                                 RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }


    // Convenience overload for zero or more modifiers
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context,
                                                                                   RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
