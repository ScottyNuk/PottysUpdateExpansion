package net.potty.pupdates.world.tree;

import net.minecraft.block.SaplingGenerator;
import net.potty.pupdates.PottysUpdates;
import net.potty.pupdates.world.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {

    public static final SaplingGenerator PALE_OAK = new SaplingGenerator(PottysUpdates.MOD_ID + ":pale_oak",
            Optional.empty(), Optional.of(ModConfiguredFeatures.PALE_OAK_KEY), Optional.empty());

    public static final SaplingGenerator MAPLE = new SaplingGenerator(
            PottysUpdates.MOD_ID + ":maple",
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.MAPLE_RANDOM_KEY),
            Optional.empty());
}
