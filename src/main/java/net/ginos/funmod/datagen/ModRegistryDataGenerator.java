package net.ginos.funmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRegistryDataGenerator extends FabricDynamicRegistryProvider {
    public ModRegistryDataGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(dataOutput, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        //entries.addAll(registries.getWrapperOrThrow(RegistryKeys.TRIM_MATERIAL));
        //entries.addAll(registries.getWrapperOrThrow(RegistryKeys.TRIM_PATTERN));
        //entries.addAll(registries.getWrapperOrThrow(RegistryKeys.ENCHANTMENT));

        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE));
        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE));

        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.DIMENSION_TYPE));
        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.BIOME));
        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.MATERIAL_RULE));
        //entries.addAll(registries.getWrapperOrThrow(RegistryKeys.CHUNK_GENERATOR_SETTINGS));
        //entries.addAll(registries.getWrapperOrThrow(RegistryKeys.DENSITY_FUNCTION));


    }

    @Override
    public String getName() {
        return "";
    }
}
