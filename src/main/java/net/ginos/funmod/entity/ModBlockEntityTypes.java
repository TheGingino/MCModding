package net.ginos.funmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.ginos.funmod.FunMod;
import net.ginos.funmod.block.ModBlocks;
import net.ginos.funmod.entity.refiner.RefinerBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntityTypes {

    public static <T extends BlockEntityType<?>> T register(String path, T blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(FunMod.MOD_ID, path), blockEntityType);
    }

    public static final BlockEntityType<RefinerBlockEntity> REFINER_BLOCK = register(
            "refiner_block",
            BlockEntityType.Builder.create(RefinerBlockEntity::new, ModBlocks.REFINER_BLOCK).build()
    );

    public static void registerBlockEntities() {
        FunMod.LOGGER.info("Registering Block Entities for " + FunMod.MOD_ID);
    }
}
