package net.ginos.funmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.ginos.funmod.block.ModBlocks;
import net.ginos.funmod.block.custom.MagicBlock;
import net.ginos.funmod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.RED_FLINT_BLOCK)
                .add(ModBlocks.RAW_RED_FLINT_BLOCK)
                .add(ModBlocks.RED_FLINT_ORE)
                .add(ModBlocks.RED_FLINT_DEEPSLATE_ORE)
                .add(ModBlocks.RED_FLINT_END_ORE)
                .add(ModBlocks.RED_FLINT_NETHER_ORE)
                .add(ModBlocks.MAGIC_BLOCK)
                .add(ModBlocks.CORRUPTED_BLOCK);
                //.add(ModBlocks.TEST_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RED_FLINT_DEEPSLATE_ORE)
                .add(ModBlocks.RED_FLINT_NETHER_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
            .add(ModBlocks.RED_FLINT_END_ORE);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.CRACKED_PINE_LEAVES);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.CORRUPTED_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.CORRUPTED_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.CORRUPTED_WALL);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MAGIC_BLOCK);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_RED_FLINT_TOOL)
                .add(ModBlocks.MAGIC_BLOCK)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.CRACKED_PINE_LOG)
                .add(ModBlocks.CRACKED_PINE_WOOD)
                .add(ModBlocks.STRIPPED_CRACKED_PINE_LOG)
                .add(ModBlocks.STRIPPED_CRACKED_PINE_WOOD);

        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(ModBlocks.CRACKED_PINE_LEAVES);
    }
}
