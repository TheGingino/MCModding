package net.ginos.funmod.recipe;

import net.ginos.funmod.FunMod;
import net.minecraft.recipe.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModRecipeType {
    public static final RecipeType<RefinerRecipe> REFINING = Registry.register(Registries.RECIPE_TYPE,
            Identifier.of(FunMod.MOD_ID, "refiner"),
            RecipeType.register("refiner")
    );


    public static void registerRecipeTypes() {
        FunMod.LOGGER.info("Registering recipe type");
    }
}
