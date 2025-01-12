package net.ginos.funmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.ginos.funmod.block.ModBlocks;
import net.ginos.funmod.item.ModItems;
import net.ginos.funmod.util.ModTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.RED_FLINT)
                .add(ModItems.BURNT_COAL)
                .add(Items.GOLD_INGOT);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.RED_FLINT_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.RED_FLINT_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.RED_FLINT_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.RED_FLINT_AXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.RED_FLINT_HOE);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.SUPER_CRUSHER);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.RED_FLINT_HELMET)
                .add(ModItems.RED_FLINT_CHESTPLATE)
                .add(ModItems.RED_FLINT_LEGGINGS)
                .add(ModItems.RED_FLINT_BOOTS);

        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(ModItems.RED_FLINT_BOOTS);

        getOrCreateTagBuilder(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(ModItems.RED_FLINT_LEGGINGS);

        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(ModItems.RED_FLINT_CHESTPLATE);

        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(ModItems.RED_FLINT_HELMET);

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.CRACKED_PINE_WOOD.asItem())
                .add(ModBlocks.CRACKED_PINE_LOG.asItem())
                .add(ModBlocks.STRIPPED_CRACKED_PINE_WOOD.asItem())
                .add(ModBlocks.STRIPPED_CRACKED_PINE_LOG.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.CRACKED_PINE_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.LEAVES)
                .add(ModBlocks.CRACKED_PINE_LEAVES.asItem());
    }
}
