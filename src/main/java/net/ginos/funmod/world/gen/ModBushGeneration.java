package net.ginos.funmod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.ginos.funmod.world.ModPlacedFeatures;
import net.ginos.funmod.world.biome.ModBiomeGeneration;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModBushGeneration {
    public static void generateBushes(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomeGeneration.FANCY_GRASS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BLUEBERRY_BUSH_PLACED_KEY);
    }
}
