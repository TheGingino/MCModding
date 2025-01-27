package net.ginos.funmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.ginos.funmod.FunMod;
import net.ginos.funmod.block.ModBlocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemsGroup {
    public static final ItemGroup RED_FLINT_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FunMod.MOD_ID, "red_flint_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.RED_FLINT))
                    .displayName(Text.translatable("itemgroup.fun-mod.red_flint_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.RED_FLINT);
                        entries.add(ModItems.RAW_RED_FLINT);

                        entries.add(ModItems.RED_FLINT_SWORD);
                        entries.add(ModItems.RED_FLINT_PICKAXE);
                        entries.add(ModItems.RED_FLINT_SHOVEL);
                        entries.add(ModItems.RED_FLINT_AXE);
                        entries.add(ModItems.RED_FLINT_HOE);

                        entries.add(ModItems.RED_FLINT_HELMET);
                        entries.add(ModItems.RED_FLINT_CHESTPLATE);
                        entries.add(ModItems.RED_FLINT_LEGGINGS);
                        entries.add(ModItems.RED_FLINT_BOOTS);
                    })
                    .build()
            );

    public static final ItemGroup RED_FLINT_BLOCK_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FunMod.MOD_ID, "red_flint_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.RED_FLINT_BLOCK))
                    .displayName(Text.translatable("itemgroup.fun-mod.red_flint_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.RED_FLINT_BLOCK);
                        entries.add(ModBlocks.RAW_RED_FLINT_BLOCK);

                        entries.add(ModBlocks.RED_FLINT_ORE);
                        entries.add(ModBlocks.RED_FLINT_DEEPSLATE_ORE);
                        entries.add(ModBlocks.RED_FLINT_END_ORE);
                        entries.add(ModBlocks.RED_FLINT_NETHER_ORE);

                        entries.add(ModBlocks.RED_FLINT_DOOR);
                        entries.add(ModBlocks.RED_FLINT_TRAPDOOR);
                        entries.add(ModBlocks.RED_FLINT_LAMP);

                        entries.add(ModBlocks.CORRUPTED_BLOCK);

                        entries.add(ModBlocks.CORRUPTED_STAIRS);
                        entries.add(ModBlocks.CORRUPTED_SLAB);

                        entries.add(ModBlocks.CORRUPTED_FENCE);
                        entries.add(ModBlocks.CORRUPTED_FENCE_GATE);
                        entries.add(ModBlocks.CORRUPTED_WALL);

                        entries.add(ModBlocks.CORRUPTED_BUTTON);
                        entries.add(ModBlocks.CORRUPTED_PRESSURE_PLATE);

                    })
                    .build()
    );

    public static final ItemGroup RED_FLINT_TOOL_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FunMod.MOD_ID, "extra_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.SUPER_CRUSHER))
                    .displayName(Text.translatable("itemgroup.fun-mod.extra_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.CHISEL);
                        entries.add(ModItems.SUPER_CRUSHER);
                        entries.add(ModItems.THORK);
                        entries.add(ModItems.HEAVY_BOW);
                        entries.add(ModBlocks.MAGIC_BLOCK);
                        entries.add(ModItems.BURNT_COAL);
                        entries.add(ModBlocks.CRACKED_PINE_WOOD);
                        entries.add(ModBlocks.STRIPPED_CRACKED_PINE_WOOD);
                        entries.add(ModBlocks.CRACKED_PINE_LOG);
                        entries.add(ModBlocks.STRIPPED_CRACKED_PINE_LOG);
                        entries.add(ModBlocks.CRACKED_PINE_PLANKS);
                        entries.add(ModBlocks.CRACKED_PINE_LEAVES);
                        entries.add(ModBlocks.CRACKED_PINE_SAPLING);
                    })
                    .build()
    );

    public static final ItemGroup EXTRA_FOOD = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FunMod.MOD_ID, "extra_food"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.FRIKANDEL))
                    .displayName(Text.translatable("itemgroup.fun-mod.extra_food"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.FRIKANDEL);
                    })
                    .build()
    );
    public static final ItemGroup MACHINES_ACCESSOR = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FunMod.MOD_ID, "machines_accessor"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.REFINER))
                    .displayName(Text.translatable("itemgroup.fun-mod.machines_accessor"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.REFINER);
                    })
                    .build()
    );


    public static void registerItemGroups(){
        FunMod.LOGGER.info("Registering ItemGroups");
    }
}
