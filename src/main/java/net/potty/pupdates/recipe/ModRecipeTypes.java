package net.potty.pupdates.recipe;

import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipeTypes {
    public static RecipeType<UpdateAltarRecipe> UPDATE_ALTAR;

    public static void registerModRecipeTypes() {
        UPDATE_ALTAR = RecipeType.register("update_altar");
        Registry.register(Registries.RECIPE_TYPE, Identifier.of("pupdates", "update_altar"), UPDATE_ALTAR);
    }
}
