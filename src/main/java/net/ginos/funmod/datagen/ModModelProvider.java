package net.ginos.funmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.ginos.funmod.block.ModBlocks;
import net.ginos.funmod.block.custom.RedFlintLampBlock;
import net.ginos.funmod.item.ModItems;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output){
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //BlockStateModelGenerator.BlockTexturePool redFlintPool =
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RED_FLINT_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_RED_FLINT_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RED_FLINT_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RED_FLINT_DEEPSLATE_ORE);

        blockStateModelGenerator.registerDoor(ModBlocks.RED_FLINT_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.RED_FLINT_TRAPDOOR);

        BlockStateModelGenerator.BlockTexturePool corruptedPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CORRUPTED_BLOCK);
        corruptedPool.stairs(ModBlocks.CORRUPTED_STAIRS);
        corruptedPool.wall(ModBlocks.CORRUPTED_WALL);
        corruptedPool.slab(ModBlocks.CORRUPTED_SLAB);

        corruptedPool.button(ModBlocks.CORRUPTED_BUTTON);
        corruptedPool.pressurePlate(ModBlocks.CORRUPTED_PRESSURE_PLATE);
        corruptedPool.fence(ModBlocks.CORRUPTED_FENCE);
        corruptedPool.fenceGate(ModBlocks.CORRUPTED_FENCE_GATE);

        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.RED_FLINT_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.RED_FLINT_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.RED_FLINT_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(RedFlintLampBlock.CLICKED,lampOnIdentifier, lampOffIdentifier)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RED_FLINT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_RED_FLINT, Models.GENERATED);

        itemModelGenerator.register(ModItems.FRIKANDEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.BURNT_COAL, Models.GENERATED);

        itemModelGenerator.register(ModItems.RED_FLINT_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RED_FLINT_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RED_FLINT_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RED_FLINT_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RED_FLINT_HOE, Models.HANDHELD);
    }
}
