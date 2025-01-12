package net.ginos.funmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.ginos.funmod.FunMod;
import net.ginos.funmod.block.ModBlocks;
import net.ginos.funmod.item.custom.ChiselItem;
import net.ginos.funmod.item.custom.HammerItem;
import net.ginos.funmod.item.custom.ModArmorItem;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.BannerPatternsComponent;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.List;

public class ModItems {
    public static final Item RED_FLINT = registerItem("red_flint", new Item(new Item.Settings()));
    public static final Item RAW_RED_FLINT = registerItem("raw_red_flint", new Item(new Item.Settings()));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));

    public static final Item FRIKANDEL = registerItem("frikandel", new Item(new Item.Settings().food(ModFoodComponents.FRIKANDEL)){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("frikandel_tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item BURNT_COAL = registerItem("burnt_coal", new Item(new Item.Settings()));

    public static final Item RED_FLINT_SWORD = registerItem("red_flint_sword",
            new SwordItem(ModToolMaterials.RED_FLINT, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.RED_FLINT,3,-2.4f))));
    public static final Item RED_FLINT_PICKAXE = registerItem("red_flint_pickaxe",
            new PickaxeItem(ModToolMaterials.RED_FLINT, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.RED_FLINT,1,-2.8f))));
    public static final Item RED_FLINT_SHOVEL = registerItem("red_flint_shovel",
            new ShovelItem(ModToolMaterials.RED_FLINT, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.RED_FLINT,1.5f,-3.0f))));
    public static final Item RED_FLINT_AXE = registerItem("red_flint_axe",
            new AxeItem(ModToolMaterials.RED_FLINT, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.RED_FLINT,6,-3.2f))));
    public static final Item RED_FLINT_HOE = registerItem("red_flint_hoe",
            new HoeItem(ModToolMaterials.RED_FLINT, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.RED_FLINT,0,-3.0f))));
    public static final Item SUPER_CRUSHER = registerItem("super_crusher",
            new HammerItem(ModToolMaterials.SUPER_CRUSHER, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.SUPER_CRUSHER,4,-2.8f))));

    public static final Item RED_FLINT_HELMET = registerItem("red_flint_helmet",
            new ArmorItem(ModArmorMaterials.RED_FLINT_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(20))));

    public static final Item RED_FLINT_CHESTPLATE = registerItem("red_flint_chestplate",
            new ArmorItem(ModArmorMaterials.RED_FLINT_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(20))));

    public static final Item RED_FLINT_LEGGINGS = registerItem("red_flint_leggings",
            new ArmorItem(ModArmorMaterials.RED_FLINT_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(20))));

    public static final Item RED_FLINT_BOOTS = registerItem("red_flint_boots",
            new ArmorItem(ModArmorMaterials.RED_FLINT_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(20))));

    public static final Item HEAVY_BOW = registerItem("heavy_bow",
            new BowItem(new Item.Settings().maxDamage(500)));

    public static final Item BLUEBERRY = registerItem("blue_berry",
            new AliasedBlockItem(ModBlocks.BLUEBERRY_BUSH, new Item.Settings().food(ModFoodComponents.BLUEBERRY)));

    public static final Item DIAMOND_SHIELD = registerItem("diamond_shield",
            new ShieldItem((new Item.Settings()).maxDamage(336).component(DataComponentTypes.BANNER_PATTERNS, BannerPatternsComponent.DEFAULT)));

    public static final Item CORRUPTED_ELYTRA = registerItem("corrupted_elytra",
            new ElytraItem((new Item.Settings()).maxDamage(432).rarity(Rarity.UNCOMMON)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FunMod.MOD_ID, name), item);
    }

    public static void RegisterModItems() {
        FunMod.LOGGER.info("Registering Mod Items" + FunMod.MOD_ID);


        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RED_FLINT);
            entries.add(RAW_RED_FLINT);
        });
    }

}
