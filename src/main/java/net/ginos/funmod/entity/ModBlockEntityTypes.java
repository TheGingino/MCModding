package net.ginos.funmod.entity;

import net.ginos.funmod.block.ModBlocks;
import net.ginos.funmod.entity.block.RefinerBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntityTypes {

    public static <T extends BlockEntityType<?>> T register(String path, T blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of("tutorial", path), blockEntityType);
    }

    public static final BlockEntityType<RefinerBlockEntity> TESTBLOCK = register(
            "demo_block",
            // For versions 1.21.2 and above,
            // replace `BlockEntityType.Builder` with `FabricBlockEntityTypeBuilder`.
            BlockEntityType.Builder.create(RefinerBlockEntity::new, ModBlocks.REFINER).build()
    );

    public static void initialize() {}
}
