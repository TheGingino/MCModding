package net.ginos.funmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.ginos.funmod.FunMod;
import net.ginos.funmod.block.custom.*;
import net.ginos.funmod.world.tree.ModSaplingGeneration;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.List;

public class ModBlocks {

    public static final Block RED_FLINT_BLOCK = registerBlock("red_flint_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block REFINER = registerBlock("refiner_block",
            new RefinerBlock(AbstractBlock.Settings.create().strength(4f).nonOpaque()));

    public static final Block RAW_RED_FLINT_BLOCK = registerBlock("raw_red_flint_block",
            new Block(AbstractBlock.Settings.create().strength(2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_CLUSTER)));

    public static final Block RED_FLINT_ORE = registerBlock("red_flint_ore",
            new RedFlintOreBlock(AbstractBlock.Settings.create()
                    .strength(3f).requiresTool().sounds(BlockSoundGroup.STONE),UniformIntProvider.create(1,8)));

    public static final Block RED_FLINT_DEEPSLATE_ORE = registerBlock("red_flint_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3,6),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block RED_FLINT_END_ORE = registerBlock("red_flint_end_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3,6),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.HEAVY_CORE)));
    public static final Block RED_FLINT_NETHER_ORE = registerBlock("red_flint_nether_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3,6),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.NETHER_ORE)));


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

   public static final Block BLUEBERRY_BUSH = registerBlockWithoutBlockItem("blueberry_bush",
           new BlueBerryBushBlock(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)));

    public static final Block CRACKED_PINE_LOG = registerBlock("cracked_pine_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));
    public static final Block CRACKED_PINE_WOOD = registerBlock("cracked_pine_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_CRACKED_PINE_LOG = registerBlock("stripped_cracked_pine_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_CRACKED_PINE_WOOD = registerBlock("stripped_cracked_pine_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final Block CRACKED_PINE_PLANKS = registerBlock("cracked_pine_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final Block CRACKED_PINE_LEAVES = registerBlock("cracked_pine_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));
    public static final Block CRACKED_PINE_SAPLING = registerBlock("cracked_pine_sapling",
            new ModSapplingBlock(ModSaplingGeneration.CRACKED_PINE, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING),CORRUPTED_BLOCK));


    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(FunMod.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(FunMod.MOD_ID, name), block);
    }

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
