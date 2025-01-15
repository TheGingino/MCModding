package net.ginos.funmod.world.gen;

import net.ginos.funmod.FunMod;
import net.ginos.funmod.block.ModBlocks;
import net.ginos.funmod.world.biome.surface.ModMaterialRules;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.dynamic.CodecHolder;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.GenerationShapeConfig;
import net.minecraft.world.gen.densityfunction.DensityFunction;
import net.minecraft.world.gen.densityfunction.DensityFunctions;
import net.minecraft.world.gen.noise.NoiseRouter;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.ArrayList;
import java.util.List;

public class ModNoiseGen {

    public static final RegistryKey<ChunkGeneratorSettings> CUSTOM_NOISE =
            RegistryKey.of(RegistryKeys.CHUNK_GENERATOR_SETTINGS,
                    Identifier.of(FunMod.MOD_ID, "custom_noise"));


    public static void bootstrapNoise(Registerable<ChunkGeneratorSettings> context) {
        context.register(CUSTOM_NOISE, new ChunkGeneratorSettings(
                GenerationShapeConfig.create(-64,384,1,1),
                ModBlocks.CORRUPTED_BLOCK.getDefaultState(),
                Blocks.WATER.getDefaultState(),
                createNoiseRouter(),
                ModMaterialRules.makeRules(),
                List.of(),
                64,
                false,
                true,
                true,
                true
        ));
    }

    private static NoiseRouter createNoiseRouter() {
        return null;
    }
}
