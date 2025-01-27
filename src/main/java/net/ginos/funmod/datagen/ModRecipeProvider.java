package net.ginos.funmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.ginos.funmod.FunMod;
import net.ginos.funmod.block.ModBlocks;
import net.ginos.funmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(dataOutput, completableFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> RED_FLINT_SMELTABLE = List.of(ModItems.RAW_RED_FLINT, ModBlocks.RED_FLINT_ORE,
                ModBlocks.RED_FLINT_DEEPSLATE_ORE);
        List<ItemConvertible> FRIKANDEL_SMELTABLE = List.of(ModItems.RAW_HORSE);
        List<ItemConvertible> RED_FLINT_CRAFTABLE = List.of(ModBlocks.RED_FLINT_DOOR,ModBlocks.RED_FLINT_TRAPDOOR);

        offerSmelting(recipeExporter, RED_FLINT_SMELTABLE, RecipeCategory.MISC, ModItems.RED_FLINT, 0.25f, 200, "red_flint");
        offerBlasting(recipeExporter, RED_FLINT_SMELTABLE, RecipeCategory.MISC, ModItems.RED_FLINT, 0.25f, 100, "red_flint");

        offerSmelting(recipeExporter, FRIKANDEL_SMELTABLE, RecipeCategory.FOOD, ModItems.COOKED_HORSE, 0.25f, 200, "cooked_horse");
        CookingRecipeJsonBuilder.createSmoking(Ingredient.ofItems(ModItems.RAW_HORSE),RecipeCategory.FOOD,ModItems.COOKED_HORSE, 0.25f,100).criterion(hasItem(ModItems.RAW_HORSE),conditionsFromItem(ModItems.RAW_HORSE))
                .offerTo(recipeExporter);


        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RED_FLINT, RecipeCategory.DECORATIONS, ModBlocks.RED_FLINT_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RAW_RED_FLINT_BLOCK,9)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.RAW_RED_FLINT)
                .criterion(hasItem(ModItems.RAW_RED_FLINT),conditionsFromItem(ModItems.RAW_RED_FLINT))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_RED_FLINT,9)
                .input(ModBlocks.RAW_RED_FLINT_BLOCK)
                .criterion(hasItem(ModBlocks.RAW_RED_FLINT_BLOCK),conditionsFromItem(ModBlocks.RAW_RED_FLINT_BLOCK))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.DIAMOND,24)
                .input(ModBlocks.MAGIC_BLOCK)
                .criterion(hasItem(ModBlocks.MAGIC_BLOCK),conditionsFromItem(ModBlocks.MAGIC_BLOCK))
                .offerTo(recipeExporter, Identifier.of(FunMod.MOD_ID, "raw_red_flint_block_from_magic_block"));



        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RED_FLINT_SWORD,1)
                .pattern(" R ")
                .pattern(" R ")
                .pattern(" S ")
                .input('R', ModItems.RED_FLINT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.RED_FLINT),conditionsFromItem(ModItems.RED_FLINT))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RED_FLINT_PICKAXE,1)
                .pattern("RRR")
                .pattern(" S ")
                .pattern(" S ")
                .input('R', ModItems.RED_FLINT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.RED_FLINT),conditionsFromItem(ModItems.RED_FLINT))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RED_FLINT_AXE,1)
                .pattern(" RR")
                .pattern(" SR")
                .pattern(" S ")
                .input('R', ModItems.RED_FLINT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.RED_FLINT),conditionsFromItem(ModItems.RED_FLINT))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RED_FLINT_SHOVEL,1)
                .pattern(" R ")
                .pattern(" S ")
                .pattern(" S ")
                .input('R', ModItems.RED_FLINT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.RED_FLINT),conditionsFromItem(ModItems.RED_FLINT))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RED_FLINT_HOE,1)
                .pattern(" RR")
                .pattern(" S ")
                .pattern(" S ")
                .input('R', ModItems.RED_FLINT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.RED_FLINT),conditionsFromItem(ModItems.RED_FLINT))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SUPER_CRUSHER,1)
                .pattern("III")
                .pattern("RSR")
                .pattern("DND")
                .input('I', Items.IRON_BLOCK)
                .input('N', Items.NETHER_STAR)
                .input('R', Items.REDSTONE)
                .input('D', Items.DIAMOND_BLOCK)
                .input('S', ModItems.BURNT_COAL)
                .criterion(hasItem(Items.DIAMOND_BLOCK),conditionsFromItem(Items.DIAMOND_BLOCK))
                .criterion(hasItem(ModItems.BURNT_COAL),conditionsFromItem(ModItems.BURNT_COAL))
                .criterion(hasItem(Items.NETHER_STAR),conditionsFromItem(Items.NETHER_STAR))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.FRIKANDEL,1)
                .input(ModItems.RAW_HORSE)
                .input(Items.BEEF)
                .input(Items.MUTTON)
                .criterion(hasItem(ModItems.RAW_HORSE),conditionsFromItem(ModItems.RAW_HORSE))
                .offerTo(recipeExporter);
        createTrapdoorRecipe(ModBlocks.RED_FLINT_TRAPDOOR, Ingredient.ofItems(ModItems.RED_FLINT))
                .criterion(hasItem(ModItems.RED_FLINT),conditionsFromItem(ModItems.RED_FLINT))
                .offerTo(recipeExporter,Identifier.of(FunMod.MOD_ID,"red_flint_trap_door"));

        createDoorRecipe(ModBlocks.RED_FLINT_DOOR, Ingredient.ofItems(ModItems.RED_FLINT))
                .criterion(hasItem(ModItems.RED_FLINT),conditionsFromItem(ModItems.RED_FLINT))
                .offerTo(recipeExporter,Identifier.of(FunMod.MOD_ID,"red_flint_door"));

    }
    public static void offerSmoking(RecipeExporter exporter, List<ItemConvertible> inputs, RecipeCategory category, ItemConvertible output, float experience, int cookingTime, String group) {
        offerMultipleOptions(exporter, RecipeSerializer.SMOKING, SmokingRecipe::new, inputs, category, output, experience, cookingTime, group, "_from_blasting");
    }
}

