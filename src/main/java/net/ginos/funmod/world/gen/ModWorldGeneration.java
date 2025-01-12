package net.ginos.funmod.world.gen;

import net.ginos.funmod.world.biome.surface.ModMaterialRules;
import net.ginos.funmod.world.dimension.ModDimension;
import net.ginos.funmod.world.tree.ModSaplingGeneration;

public class ModWorldGeneration {
    public static void generateModWorldGen(){
        ModOreGeneration.generateOre();
        ModTreeGeneration.generateTrees();

        ModBushGeneration.generateBushes();


    }
}
