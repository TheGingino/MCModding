package net.ginos.funmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.ginos.funmod.FunMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RED_FLINT = registerItem("red_flint", new Item(new Item.Settings()));
    public static final Item RAW_RED_FLINT = registerItem("raw_red_flint", new Item(new Item.Settings()));


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
