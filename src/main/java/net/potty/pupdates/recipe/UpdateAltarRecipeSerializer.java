package net.potty.pupdates.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;

public class UpdateAltarRecipeSerializer implements RecipeSerializer<UpdateAltarRecipe> {
    public static final MapCodec<UpdateAltarRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Codec.STRING.optionalFieldOf("group", "").forGetter(r -> r.getGroup()),
            Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(r -> r.ingredient),
            ItemStack.VALIDATED_CODEC.fieldOf("result").forGetter(r -> r.getResult(null)) // WrapperLookup not needed here
    ).apply(instance, UpdateAltarRecipe::new));

    public static final PacketCodec<RegistryByteBuf, UpdateAltarRecipe> PACKET_CODEC = PacketCodec.tuple(
            PacketCodecs.STRING, UpdateAltarRecipe::getGroup,
            Ingredient.PACKET_CODEC, r -> r.ingredient,
            ItemStack.PACKET_CODEC, r -> r.getResult(null),
            UpdateAltarRecipe::new
    );

    @Override
    public MapCodec<UpdateAltarRecipe> codec() {
        return CODEC;
    }

    @Override
    public PacketCodec<RegistryByteBuf, UpdateAltarRecipe> packetCodec() {
        return PACKET_CODEC;
    }
}
