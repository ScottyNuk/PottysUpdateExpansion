package net.potty.pupdates.recipe;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.world.World;

public class UpdateAltarRecipe extends ModCuttingRecipe {
    public UpdateAltarRecipe(String group, Ingredient ingredient, ItemStack result) {
        super(ModRecipeTypes.UPDATE_ALTAR, ModRecipeSerializers.UPDATE_ALTAR, group, ingredient, result);
    }

    public boolean matches(SingleStackRecipeInput singleStackRecipeInput, World world) {
        return this.ingredient.test(singleStackRecipeInput.item());
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Blocks.STONECUTTER);
    }
    public Ingredient getIngredient() {
        return this.ingredient;
    }

    public ItemStack getResultItemStack() {
        return this.result;
    }
}

