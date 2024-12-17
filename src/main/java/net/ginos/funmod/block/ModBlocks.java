package net.ginos.funmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.ginos.funmod.FunMod;
import net.ginos.funmod.block.custom.MagicBlock;
import net.ginos.funmod.block.custom.RedFlintLampBlock;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block RED_FLINT_BLOCK = registerBlock("red_flint_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RAW_RED_FLINT_BLOCK = registerBlock("raw_red_flint_block",
            new Block(AbstractBlock.Settings.create().strength(2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_CLUSTER)));

    public static final Block RED_FLINT_ORE = registerBlock("red_flint_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block RED_FLINT_DEEPSLATE_ORE = registerBlock("red_flint_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3,6),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create().strength(1)
                    .requiresTool()
            ));

    public static final Block CORRUPTED_BLOCK = registerBlock("corrupted_block",
            new Block(AbstractBlock.Settings.create().strength(2f)
                    //.requiresTool()
                    .sounds(BlockSoundGroup.LODESTONE)));

    public static final Block CORRUPTED_STAIRS = registerBlock("corrupted_stairs",
            new StairsBlock(ModBlocks.CORRUPTED_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.create().strength(1f).requiresTool()));
    public static final Block CORRUPTED_SLAB = registerBlock("corrupted_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(1f).requiresTool()));

    public static final Block CORRUPTED_BUTTON = registerBlock("corrupted_button",
            new ButtonBlock(BlockSetType.IRON,20, AbstractBlock.Settings.create().strength(2f).requiresTool().noCollision()));

    public static final Block CORRUPTED_PRESSURE_PLATE = registerBlock("corrupted_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON,AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block CORRUPTED_FENCE = registerBlock("corrupted_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(1f).requiresTool()));

    public static final Block CORRUPTED_FENCE_GATE = registerBlock("corrupted_fence_gate",
            new FenceGateBlock(WoodType.OAK,AbstractBlock.Settings.create().strength(1f).requiresTool()));

    public static final Block CORRUPTED_WALL = registerBlock("corrupted_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(1f).requiresTool()));

    public static final Block RED_FLINT_DOOR = registerBlock("red_flint_door",
            new DoorBlock(BlockSetType.IRON,
                    AbstractBlock.Settings.create().strength(1f).requiresTool().nonOpaque()));

    public static final Block RED_FLINT_TRAPDOOR = registerBlock("red_flint_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON,
                    AbstractBlock.Settings.create().strength(1f).requiresTool().nonOpaque()));

    public static final Block RED_FLINT_LAMP = registerBlock("red_flint_lamp",
            new RedFlintLampBlock(AbstractBlock.Settings.create()
                    .strength(1f).requiresTool().luminance(state -> state.get(RedFlintLampBlock.CLICKED)? 15 :0)));



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(FunMod.MOD_ID, name), block);
    };

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(FunMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void RegisterModBlocks() {
        FunMod.LOGGER.info("Registering Mod Blocks" + FunMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries ->{
            entries.add(RED_FLINT_BLOCK);
            entries.add(RAW_RED_FLINT_BLOCK);
        });
    }
}
