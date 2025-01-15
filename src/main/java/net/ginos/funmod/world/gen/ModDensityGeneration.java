package net.ginos.funmod.world.gen;

import net.ginos.funmod.FunMod;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.dynamic.CodecHolder;
import net.minecraft.world.gen.densityfunction.DensityFunction;

public class ModDensityGeneration {
    public static final RegistryKey<DensityFunction> CUSTOM_DENSITY = RegistryKey.of(RegistryKeys.DENSITY_FUNCTION,
            Identifier.of(FunMod.MOD_ID, "custom_density"));

    public static void bootstrap(Registerable<DensityFunction> context) {
        context.register(CUSTOM_DENSITY, new DensityFunction() {
            @Override
            public double sample(NoisePos pos) {
                return Math.sin(pos.blockX() * 0.01);
            }

            @Override
            public void fill(double[] densities, EachApplier applier) {

            }

            @Override
            public DensityFunction apply(DensityFunctionVisitor visitor) {
                return this;
            }

            @Override
            public double minValue() {
                return 0;
            }

            @Override
            public double maxValue() {
                return 0;
            }

            @Override
            public CodecHolder<? extends DensityFunction> getCodecHolder() {
                return getCodecHolder();
            }
        });
    }
}
