package net.ginos.funmod.world;

import net.ginos.funmod.FunMod;
import net.ginos.funmod.block.ModBlocks;
import net.ginos.funmod.block.custom.BlueBerryBushBlock;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_FLINT_ORE_KEY = registerKey("red_flint_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_RED_FLINT_ORE_KEY = registerKey("nether_red_flint_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_RED_FLINT_ORE_KEY = registerKey("end_red_flint_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> CRACKED_PINE_KEY = registerKey("cracked_pine");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUEBERRY_BUSH_KEY = registerKey("blueberry_bush");




    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new BlockMatchRuleTest(Blocks.STONE);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldRedFlintOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.RED_FLINT_ORE.getDefaultState())
        ,OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.RED_FLINT_DEEPSLATE_ORE.getDefaultState()));

        //List<OreFeatureConfig.Target> netherRedFlintOres =
        //        List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.RED_FLINT_NETHER_ORE.getDefaultState()));

        // List<OreFeatureConfig.Target> endRedFlintOres =
        //        List.of(OreFeatureConfig.createTarget(endReplaceables, ModBlocks.RED_FLINT_END_ORE.getDefaultState()));


        register(context, RED_FLINT_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldRedFlintOres,6));
        //register(context, END_RED_FLINT_ORE_KEY, Feature.ORE, new OreFeatureConfig(endRedFlintOres,1));
        //register(context, NETHER_RED_FLINT_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherRedFlintOres,1));

        register(context, CRACKED_PINE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.CRACKED_PINE_LOG),
                new StraightTrunkPlacer(5, 6, 3),


                BlockStateProvider.of(ModBlocks.CRACKED_PINE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(1), 3),

                new TwoLayersFeatureSize(1, 0, 2)).dirtProvider(BlockStateProvider.of(ModBlocks.CORRUPTED_BLOCK)).build());


        register(context, BLUEBERRY_BUSH_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUEBERRY_BUSH.getDefaultState().with(BlueBerryBushBlock.AGE,3)
                                )),List.of(Blocks.GRASS_BLOCK)));

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(FunMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
