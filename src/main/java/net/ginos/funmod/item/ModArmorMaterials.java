package net.ginos.funmod.item;

import com.google.common.base.Suppliers;
import net.ginos.funmod.FunMod;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class ModArmorMaterials{
    public static final RegistryEntry<ArmorMaterial> RED_FLINT_ARMOR_MATERIAL = registerArmorMaterials("red_flint",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS,2);
                map.put(ArmorItem.Type.LEGGINGS,4);
                map.put(ArmorItem.Type.CHESTPLATE,6);
                map.put(ArmorItem.Type.HELMET,2);
                map.put(ArmorItem.Type.BODY,4);
            }),20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.RED_FLINT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(FunMod.MOD_ID,"red_flint"))),2,0));


    public static RegistryEntry<ArmorMaterial> registerArmorMaterials(String name, Supplier<ArmorMaterial> material){
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(FunMod.MOD_ID, name), material.get());
    }
}
