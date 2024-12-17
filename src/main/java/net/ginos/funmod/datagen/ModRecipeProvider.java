package net.ginos.funmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.ginos.funmod.FunMod;
import net.ginos.funmod.block.ModBlocks;
import net.ginos.funmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
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

        offerSmelting(recipeExporter, RED_FLINT_SMELTABLE, RecipeCategory.MISC, ModItems.RED_FLINT, 0.25f, 200, "red_flint");
        offerBlasting(recipeExporter, RED_FLINT_SMELTABLE, RecipeCategory.MISC, ModItems.RED_FLINT, 0.25f, 100, "red_flint");

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

    }
}
