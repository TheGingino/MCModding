package net.ginos.funmod.world;

import net.ginos.funmod.FunMod;
import net.ginos.funmod.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;


public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> RED_FLINT_ORE_PLACED_KEY = registerKey("red_flint_ore_placed");
    public static final RegistryKey<PlacedFeature> NETHER_RED_FLINT_ORE_PLACED_KEY = registerKey("nether_red_flint_ore_placed");
    public static final RegistryKey<PlacedFeature> END_RED_FLINT_ORE_PLACED_KEY = registerKey("end_red_flint_ore_placed");
    public static final RegistryKey<PlacedFeature> CRACKED_PINE_KEY = registerKey("cracked_pine_placed");
    public static final RegistryKey<PlacedFeature> BLUEBERRY_BUSH_PLACED_KEY = registerKey("blueberry_bush_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, RED_FLINT_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RED_FLINT_ORE_KEY),
                ModOrePlacement.modifiersWithCount(2,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-24), YOffset.fixed(-20))));
        register(context, NETHER_RED_FLINT_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_RED_FLINT_ORE_KEY),
                ModOrePlacement.modifiersWithCount(2,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(8), YOffset.fixed(12))));
        register(context, END_RED_FLINT_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_RED_FLINT_ORE_KEY),
                ModOrePlacement.modifiersWithCount(2,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));

        register(context, CRACKED_PINE_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRACKED_PINE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(2,0.1f,2), ModBlocks.CRACKED_PINE_SAPLING
                ));

        register(context, BLUEBERRY_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BLUEBERRY_BUSH_KEY),
                RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of());
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(FunMod.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
