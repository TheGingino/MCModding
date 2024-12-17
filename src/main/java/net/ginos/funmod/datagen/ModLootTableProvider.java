package net.ginos.funmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.ginos.funmod.block.ModBlocks;
import net.ginos.funmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }


    @Override
    public void generate(){
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
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrop, float maxDrop){
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop,this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrop,maxDrop))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
