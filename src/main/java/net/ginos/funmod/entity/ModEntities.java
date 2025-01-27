package net.ginos.funmod.entity;


import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.ginos.funmod.FunMod;
import net.ginos.funmod.entity.Thork.ThorkEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
public class ModEntities {

    public static EntityType<ThorkEntity> THORK = register("thork", createEntityType(ThorkEntity::new));;



    public static void registerModEntities() {
        FunMod.LOGGER.info("Registering Mod Entities");
    }

    private static <T extends Entity> EntityType<T> register(String s, EntityType<T> bombEntityType) {
        return Registry.register(Registries.ENTITY_TYPE, FunMod.MOD_ID + ":" + s, bombEntityType);
    }

    private static <T extends Entity> EntityType<T> createEntityType(EntityType.EntityFactory<T> factory) {
        return FabricEntityTypeBuilder.create(SpawnGroup.MISC, factory).dimensions(EntityDimensions.changing(0.5f, 0.5f)).trackRangeBlocks(4).trackedUpdateRate(20).build();
    }

    private static <T extends Entity> EntityType<T> createDynamicEntityType(EntityType.EntityFactory<T> factory) {
        return FabricEntityTypeBuilder.create(SpawnGroup.MISC, factory).dimensions(EntityDimensions.changing(0.5f, 0.5f)).trackRangeBlocks(4).build();
    }
}
