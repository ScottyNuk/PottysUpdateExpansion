package net.potty.pupdates.world.gen.treedecorator;

import com.mojang.serialization.MapCodec;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class ModTreeDecoratorType {
    public static final TreeDecoratorType<PaleMossTreeDecorator> PALE_MOSS =
            register("pale_moss", PaleMossTreeDecorator.CODEC);

    private static <P extends TreeDecorator> TreeDecoratorType<P> register(String name, MapCodec<P> codec) {
        return Registry.register(Registries.TREE_DECORATOR_TYPE, Identifier.of("pupdates", name), new TreeDecoratorType<>(codec));
    }

    public static void registerAll() {
        // Just to ensure class gets loaded at startup
    }
}