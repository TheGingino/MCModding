package net.ginos.funmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.ginos.funmod.FunMod;
import net.ginos.funmod.block.ModBlocks;
import net.ginos.funmod.block.custom.BlueBerryBushBlock;
import net.ginos.funmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.loottable.EntityLootTableGenerator;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import javax.swing.text.html.parser.Entity;
import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }


    @Override
    public void generate(){
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

        addDrop(ModBlocks.RED_FLINT_BLOCK);
        addDrop(ModBlocks.RAW_RED_FLINT_BLOCK);
        addDrop(ModBlocks.MAGIC_BLOCK);
        addDrop(ModBlocks.RED_FLINT_LAMP);

        addDrop(ModBlocks.RED_FLINT_ORE, oreDrops(ModBlocks.RED_FLINT_ORE, ModItems.RAW_RED_FLINT));
        addDrop(ModBlocks.RED_FLINT_DEEPSLATE_ORE, multipleOreDrops(ModBlocks.RED_FLINT_DEEPSLATE_ORE,ModItems.RAW_RED_FLINT,1,4));

        addDrop(ModBlocks.CORRUPTED_BLOCK);
        addDrop(ModBlocks.CORRUPTED_STAIRS);
        addDrop(ModBlocks.CORRUPTED_SLAB,slabDrops(ModBlocks.CORRUPTED_SLAB));

        addDrop(ModBlocks.CORRUPTED_WALL);
        addDrop(ModBlocks.CORRUPTED_PRESSURE_PLATE);
        addDrop(ModBlocks.CORRUPTED_BUTTON);
        addDrop(ModBlocks.CORRUPTED_FENCE);
        addDrop(ModBlocks.CORRUPTED_FENCE_GATE);

        addDrop(ModBlocks.RED_FLINT_DOOR,doorDrops(ModBlocks.RED_FLINT_DOOR));
        addDrop(ModBlocks.RED_FLINT_TRAPDOOR);

        this.addDrop(ModBlocks.BLUEBERRY_BUSH,
                block -> this.applyExplosionDecay(
                        block
                        ,LootTable.builder().pool
                                (LootPool.builder().conditionally(
                                                BlockStatePropertyLootCondition.builder(ModBlocks.BLUEBERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(BlueBerryBushBlock.AGE, 3))
                                        )
                                        .with(ItemEntry.builder(ModItems.BLUEBERRY))
                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                                        .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                        ).pool
                                (LootPool.builder().conditionally(
                                        BlockStatePropertyLootCondition.builder(ModBlocks.BLUEBERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(BlueBerryBushBlock.AGE, 2))
                                ).with(ItemEntry.builder(ModItems.BLUEBERRY))
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))))
                ));

        addDrop(ModBlocks.RED_FLINT_END_ORE, multipleOreDrops(ModBlocks.RED_FLINT_END_ORE,ModItems.RED_FLINT,1,4));
        addDrop(ModBlocks.RED_FLINT_NETHER_ORE,multipleOreDrops(ModBlocks.RED_FLINT_NETHER_ORE,ModItems.RED_FLINT,2,7));

        addDrop(ModBlocks.CRACKED_PINE_LEAVES, leavesDrops(ModBlocks.CRACKED_PINE_LEAVES, ModBlocks.CRACKED_PINE_SAPLING, 0.0625f));
        addDrop(ModBlocks.CRACKED_PINE_LOG);
        addDrop(ModBlocks.CRACKED_PINE_WOOD);
        addDrop(ModBlocks.STRIPPED_CRACKED_PINE_WOOD);

        //addDrop(ModBlocks.TEST_BLOCK);

    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
