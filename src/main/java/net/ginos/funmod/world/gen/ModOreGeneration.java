package net.ginos.funmod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.ginos.funmod.world.ModPlacedFeatures;
import net.ginos.funmod.world.biome.ModBiomeGeneration;
import net.ginos.funmod.world.dimension.ModDimension;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.OrePlacedFeatures;

import java.util.function.Predicate;

public class ModOreGeneration {
    public static void generateOre(){
        //BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
        //        ModPlacedFeatures.RED_FLINT_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
               ModPlacedFeatures.RED_FLINT_ORE_PLACED_KEY);
        BiomeModifications.addFeature(biomeSelectionContext -> biomeSelectionContext.canGenerateIn(ModDimension.CORRUPTED_KEY),
                GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.RED_FLINT_ORE_PLACED_KEY);



        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomeGeneration.FANCY_GRASS), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.RED_FLINT_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomeGeneration.CORRUPTED_BIOME), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.RED_FLINT_ORE_PLACED_KEY);

        //BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES,
        //       ModPlacedFeatures.NETHER_RED_FLINT_ORE_PLACED_KEY);
        //BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES,
        //        ModPlacedFeatures.END_RED_FLINT_ORE_PLACED_KEY);
    }

    public static Predicate<BiomeSelectionContext> foundInCorruptedDimension() {
        return context -> context.canGenerateIn(ModDimension.CORRUPTED_KEY);
    }
}
