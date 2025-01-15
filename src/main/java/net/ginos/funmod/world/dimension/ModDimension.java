package net.ginos.funmod.world.dimension;

import net.ginos.funmod.FunMod;

import net.ginos.funmod.world.biome.surface.ModMaterialRules;
import net.minecraft.registry.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

import java.util.OptionalLong;


public class ModDimension {

    public static final RegistryKey<DimensionOptions> CORRUPTED_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            Identifier.of(FunMod.MOD_ID, "corrupted_dim_type"));
    public static final RegistryKey<World> CORRUPTED_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            Identifier.of(FunMod.MOD_ID, "corrupted_dim"));
    public static final RegistryKey<DimensionType> CORRUPTED_DIM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            Identifier.of(FunMod.MOD_ID, "corrupted_dim_type"));



    //public static final Identifier CORRUPTED_DIM_ID = Identifier.of(FunMod.MOD_ID, "corrupted_dim");


    public static void bootstrapType(Registerable<DimensionType> context) {
        context.register(CORRUPTED_DIM_TYPE, new DimensionType(
                OptionalLong.of(12000),
                false,
                false,
                false,
                true,
                1.0,
                true,
                false,
                -64,
                384,
                384,
                BlockTags.INFINIBURN_OVERWORLD,
                DimensionTypes.OVERWORLD_ID,
                1.0f,
                new DimensionType.MonsterSettings(false,false, UniformIntProvider.create(0,0),0)
        ));
    }

}
