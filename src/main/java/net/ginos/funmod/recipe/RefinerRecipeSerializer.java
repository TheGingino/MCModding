package net.ginos.funmod.recipe;

import com.mojang.serialization.MapCodec;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.RecipeSerializer;

public class RefinerRecipeSerializer implements RecipeSerializer<RefinerRecipe> {
    public static RefinerRecipeSerializer INSTANCE = new RefinerRecipeSerializer();
    public static String id;


    @Override
    public MapCodec<RefinerRecipe> codec() {
        //return null;
        return (MapCodec<RefinerRecipe>) RefinerRecipe.CODEC;
    }

    @Override
    public PacketCodec<RegistryByteBuf, RefinerRecipe> packetCodec() {
        //return null;
        return RefinerRecipe.PACKET_CODEC;
    }
}
