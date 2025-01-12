package net.ginos.funmod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.ginos.funmod.datagen.*;
import net.ginos.funmod.world.ModConfiguredFeatures;
import net.ginos.funmod.world.ModPlacedFeatures;
import net.ginos.funmod.world.biome.ModBiomeGeneration;
import net.ginos.funmod.world.biome.surface.ModMaterialRules;
import net.ginos.funmod.world.dimension.ModDimension;
import net.ginos.funmod.world.gen.ModBushGeneration;
import net.ginos.funmod.world.gen.ModNoiseGen;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class FunModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
			FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

			pack.addProvider(ModBlockTagProvider::new);
			pack.addProvider(ModItemTagProvider::new);
			pack.addProvider(ModLootTableProvider::new);
			pack.addProvider(ModModelProvider::new);
			pack.addProvider(ModRecipeProvider::new);
			pack.addProvider(ModRegistryDataGenerator::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.DIMENSION_TYPE, ModDimension::bootstrapType);
		registryBuilder.addRegistry(RegistryKeys.BIOME, ModBiomeGeneration::bootstrapBiomes);
		//registryBuilder.addRegistry(RegistryKeys.CHUNK_GENERATOR_SETTINGS, ModNoiseGen::bootstrapNoiseGen);

	}
}
