package net.ginos.funmod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.ginos.funmod.world.ModPlacedFeatures;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {
    public static void generateOre(){
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.RED_FLINT_ORE_PLACED_KEY);

        //Voorbeeld voor specifieke biomes
        //BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.COLD_OCEAN), GenerationStep.Feature.UNDERGROUND_ORES,
        //        ModPlacedFeatures.RED_FLINT_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.NETHER_RED_FLINT_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.END_RED_FLINT_ORE_PLACED_KEY);
    }
}
