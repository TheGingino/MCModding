package net.ginos.funmod.world.biome.surface;

import net.ginos.funmod.FunMod;
import net.ginos.funmod.block.ModBlocks;
import net.ginos.funmod.world.biome.ModBiomeGeneration;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {

    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule CORRUPTED_BLOCK = makeStateRule(ModBlocks.CORRUPTED_BLOCK);
    //private static final MaterialRules.MaterialRule CRACKED_DIRT = makeStateRule(Blocks.DIRT);
    //private static final MaterialRules.MaterialRule FLAME = makeStateRule(Blocks.DIRT);

    public static MaterialRules.MaterialRule makeRules(){
        MaterialRules.MaterialCondition isAboverWaterLevel = MaterialRules.water(-1,0);

        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAboverWaterLevel, CORRUPTED_BLOCK), DIRT);
        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomeGeneration.CORRUPTED_BIOME),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR,CORRUPTED_BLOCK)),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING,CORRUPTED_BLOCK)),


                MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, grassSurface)
        );
    }


    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }

}
