package net.ginos.funmod.world.biome;

import net.fabricmc.fabric.api.biome.v1.BiomeModificationContext;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.ginos.funmod.FunMod;
import net.ginos.funmod.world.ModPlacedFeatures;
import net.ginos.funmod.world.biome.surface.ModMaterialRules;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicType;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class ModBiomeGeneration {

    public static RegistryKey<Biome> CORRUPTED_BIOME = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(FunMod.MOD_ID, "corrupted_biome"));
    public static RegistryKey<Biome> FANCY_GRASS = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(FunMod.MOD_ID, "fancy_grass"));


    public static void bootstrapBiomes(Registerable<Biome> context) {
        context.register(CORRUPTED_BIOME, testBiome(context));
        context.register(FANCY_GRASS, fancyBiome(context));
    }

    public static void globalOverworldBiomes(GenerationSettings.LookupBackedBuilder context) {
        DefaultBiomeFeatures.addLandCarvers(context);
        DefaultBiomeFeatures.addAmethystGeodes(context);
        DefaultBiomeFeatures.addDungeons(context);
        DefaultBiomeFeatures.addMineables(context);
        DefaultBiomeFeatures.addSprings(context);
    }


    public static Biome testBiome(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.ALLAY, 2,3,5));
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.ILLUSIONER, 2,3,5));

        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldBiomes(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
        DefaultBiomeFeatures.addBadlandsPlateauTrees(biomeBuilder);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_PLAINS);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4f)
                .temperature(0.45f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0xe82e3b)
                        .waterFogColor(0xe82e4b)
                        .skyColor(3867138)
                        .grassColor(0x67138)
                        .fogColor(0x22a1e6)
                        .moodSound(BiomeMoodSound.CAVE)
                        .music(MusicType.createIngameMusic(SoundEvents.MUSIC_GAME)).build())
                .build();

    }

    public static Biome fancyBiome(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 2,3,5));

        DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldBiomes(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_TAIGA);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4f)
                .temperature(0.65f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .skyColor(0x5341b)
                        .grassColor(0x67138)
                        .waterColor(0x22a1e6)
                        .waterFogColor(0x22a1e9)
                        .fogColor(0x22a1e6)
                        .moodSound(BiomeMoodSound.CAVE)
                        .music(MusicType.createIngameMusic(SoundEvents.MUSIC_GAME)).build())
                .build();

    }

}
