package net.ginos.funmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.ginos.funmod.block.ModBlocks;
import net.ginos.funmod.entity.ModBlockEntityTypes;
import net.ginos.funmod.entity.ModEntities;
import net.ginos.funmod.entity.Thork.ThorkEntity;
import net.ginos.funmod.entity.Thork.ThorkEntityModel;
import net.ginos.funmod.entity.Thork.ThorkEntityRenderer;
import net.ginos.funmod.item.custom.ThorkItem;
import net.ginos.funmod.screen.ModScreenHandlers;
import net.ginos.funmod.screen.RefinerBlockScreen;
import net.ginos.funmod.util.ModModelPredicates;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

public class FunModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_FLINT_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_FLINT_DOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUEBERRY_BUSH, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CRACKED_PINE_SAPLING, RenderLayer.getCutout());

        ModModelPredicates.registerModelPredicates();


        EntityModelLayerRegistry.registerModelLayer(ThorkEntityModel.THORK, ThorkEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.THORK, ThorkEntityRenderer::new);
        HandledScreens.register(ModScreenHandlers.REFINER_BLOCK_SCREEN, RefinerBlockScreen::new);

    }
}
