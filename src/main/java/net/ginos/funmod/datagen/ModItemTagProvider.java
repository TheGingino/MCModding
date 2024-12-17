package net.ginos.funmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.ginos.funmod.block.ModBlocks;
import net.ginos.funmod.item.ModItems;
import net.ginos.funmod.util.ModTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
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

    }
}
