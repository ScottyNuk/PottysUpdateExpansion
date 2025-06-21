package net.potty.pupdates.recipe;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.potty.pupdates.PottysUpdates;

public class ModRecipeSerializers {
    public static final RecipeSerializer<UpdateAltarRecipe> UPDATE_ALTAR =
            Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of("pupdates", "update_altar"), new UpdateAltarRecipeSerializer());

    public static void registerModSerializers() {
        PottysUpdates.LOGGER.info("Registering Mod Serializers for " + PottysUpdates.MOD_ID);

    }
}
