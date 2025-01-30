package net.ginos.funmod.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.ginos.funmod.entity.refiner.RefineData;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Optional;


public class RefinerRecipe implements Recipe<RefinerRecipeInput> {

    public final Ingredient input;
    public final ItemStack output;

    public static final Codec<RefinerRecipe> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("input").forGetter(recipe -> recipe.input),
            ItemStack.CODEC.fieldOf("output").forGetter(recipe -> recipe.output)
    ).apply(instance, RefinerRecipe::new));

    public static final PacketCodec<RegistryByteBuf, RefinerRecipe> PACKET_CODEC =
            PacketCodec.tuple(
                    Ingredient.PACKET_CODEC, recipe -> recipe.input,
                    ItemStack.PACKET_CODEC,recipe -> recipe.output,
                    RefinerRecipe::new);


    public RefinerRecipe(Ingredient input, ItemStack output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public boolean matches(RefinerRecipeInput input, World world) {
        return false;
        //return this.input.test(input.getStackInSlot(0));//& inputB.test(inventory.getStack(1));
    }

    @Override
    public ItemStack craft(RefinerRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return null;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {

        return RefinerRecipeSerializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipeType.REFINING;
        //return null;
    }
    //public static class Type implements RecipeType<RefinerRecipe> {
    //    private Type() {}
    //    public static final Type INSTANCE = new Type();
    //    public static final String ID = "refiner_recipe";
    //}
}
