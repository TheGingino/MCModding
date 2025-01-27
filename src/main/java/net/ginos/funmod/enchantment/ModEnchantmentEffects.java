package net.ginos.funmod.enchantment;

import com.mojang.serialization.MapCodec;
import net.ginos.funmod.FunMod;
import net.ginos.funmod.enchantment.custom.DrowningFeelEnchantment;
import net.ginos.funmod.enchantment.custom.LightingStrikeEnchantment;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantmentEffects {
    public static final MapCodec<? extends EnchantmentEntityEffect> LIGHTING_STRIKE =
            registerEntityEffect("lightning_strike", LightingStrikeEnchantment.CODEC);

    public static final MapCodec<? extends EnchantmentEntityEffect> DROWNED_FEEL =
            registerEntityEffect("drowned_feel", DrowningFeelEnchantment.CODEC);

    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name,
                                                                                    MapCodec<? extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(FunMod.MOD_ID, name), codec);
    }

    public static void registerEnchantmentEffects() {
        FunMod.LOGGER.info("Registering enchantment effects" + FunMod.MOD_ID);
    }

}
