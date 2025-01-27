package net.ginos.funmod.enchantment;

import net.ginos.funmod.FunMod;
import net.ginos.funmod.enchantment.custom.DrowningFeelEnchantment;
import net.ginos.funmod.enchantment.custom.LightingStrikeEnchantment;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

public class ModEnchantments {

    public static final RegistryKey<Enchantment> LIGHTNING_STRIKE =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(FunMod.MOD_ID, "lightning_strike"));

    public static final RegistryKey<Enchantment> DROWNED_FEEL =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(FunMod.MOD_ID, "drowned_feel"));


    public static void bootstrap(Registerable<Enchantment> registerable) {
        var enchantment = registerable.getRegistryLookup(RegistryKeys.ENCHANTMENT);
        var items = registerable.getRegistryLookup(RegistryKeys.ITEM);

        register(registerable, LIGHTNING_STRIKE, Enchantment.builder(Enchantment.definition(
                items.getOrThrow(ItemTags.TRIDENT_ENCHANTABLE),
                5,
                2,
                Enchantment.leveledCost(5,7),
                Enchantment.leveledCost(25,9),
                2,
                AttributeModifierSlot.MAINHAND,
                AttributeModifierSlot.OFFHAND))
                .exclusiveSet(enchantment.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM,
                        new LightingStrikeEnchantment())
        );



        register(registerable, DROWNED_FEEL, Enchantment.builder(Enchantment.definition(
                        items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                        items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                        5,
                        2,
                        Enchantment.leveledCost(5,7),
                        Enchantment.leveledCost(25,9),
                        2,
                        AttributeModifierSlot.MAINHAND,
                        AttributeModifierSlot.OFFHAND))
                .exclusiveSet(enchantment.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.DAMAGING_ENTITY, EnchantmentEffectTarget.VICTIM,
                        new DrowningFeelEnchantment())
        );
    }

    private static void register(Registerable<Enchantment> registry, RegistryKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.getValue()));
    }
}
