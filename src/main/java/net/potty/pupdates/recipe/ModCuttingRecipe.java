package net.potty.pupdates.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;

/**
 * A recipe that has only one input ingredient. It can be used by any type
 * of recipe as long as its subclass implements the proper interface.
 */
public abstract class ModCuttingRecipe implements Recipe<SingleStackRecipeInput> {
    public final Ingredient ingredient;
    public final ItemStack result;
    public final RecipeType<?> type;
    public final RecipeSerializer<?> serializer;
    public final String group;

    public ModCuttingRecipe(RecipeType<?> type, RecipeSerializer<?> serializer, String group, Ingredient ingredient, ItemStack result) {
        this.type = type;
        this.serializer = serializer;
        this.group = group;
        this.ingredient = ingredient;
        this.result = result;
    }

    @Override
    public RecipeType<?> getType() {
        return this.type;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return this.serializer;
    }

    @Override
    public String getGroup() {
        return this.group;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return this.result;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> defaultedList = DefaultedList.of();
        defaultedList.add(this.ingredient);
        return defaultedList;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    public ItemStack craft(SingleStackRecipeInput singleStackRecipeInput, RegistryWrapper.WrapperLookup wrapperLookup) {
        return this.result.copy();
    }

    public interface RecipeFactory<T extends ModCuttingRecipe> {
        T create(String group, Ingredient ingredient, ItemStack result);
    }

    public static class Serializer<T extends ModCuttingRecipe> implements RecipeSerializer<T> {
        final ModCuttingRecipe.RecipeFactory<T> recipeFactory;
        private final MapCodec<T> codec;
        private final PacketCodec<RegistryByteBuf, T> packetCodec;

        protected Serializer(ModCuttingRecipe.RecipeFactory<T> recipeFactory) {
            this.recipeFactory = recipeFactory;
            this.codec = RecordCodecBuilder.mapCodec(
                    instance -> instance.group(
                                    Codec.STRING.optionalFieldOf("group", "").forGetter(recipe -> recipe.group),
                                    Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(recipe -> recipe.ingredient),
                                    ItemStack.VALIDATED_CODEC.fieldOf("result").forGetter(recipe -> recipe.result)
                            )
                            .apply(instance, recipeFactory::create)
            );
            this.packetCodec = PacketCodec.tuple(
                    PacketCodecs.STRING,
                    recipe -> recipe.group,
                    Ingredient.PACKET_CODEC,
                    recipe -> recipe.ingredient,
                    ItemStack.PACKET_CODEC,
                    recipe -> recipe.result,
                    recipeFactory::create
            );
        }

        @Override
        public MapCodec<T> codec() {
            return this.codec;
        }

        @Override
        public PacketCodec<RegistryByteBuf, T> packetCodec() {
            return this.packetCodec;
        }
    }
}
