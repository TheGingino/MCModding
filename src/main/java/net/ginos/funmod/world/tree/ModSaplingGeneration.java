package net.ginos.funmod.world.tree;

import net.ginos.funmod.FunMod;
import net.ginos.funmod.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGeneration {
    public static final SaplingGenerator CRACKED_PINE = new SaplingGenerator(FunMod.MOD_ID + ":cracked_pine",
            Optional.empty(), Optional.of(ModConfiguredFeatures.CRACKED_PINE_KEY),Optional.empty());

}
