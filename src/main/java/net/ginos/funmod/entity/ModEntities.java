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
import net.minecraft.util.Identifier;

public class ModEntities {

    public static EntityType<ThorkEntity> THORK = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(FunMod.MOD_ID,"thork"),
            EntityType.Builder.<ThorkEntity>create(ThorkEntity::new,
                    SpawnGroup.MISC).dimensions(0.5f,0.5f).build());


    public static void registerModEntities() {
        FunMod.LOGGER.info("Registering Mod Entities");
    }
}
