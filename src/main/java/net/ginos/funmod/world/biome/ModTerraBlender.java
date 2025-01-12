package net.ginos.funmod.world.biome;

import net.ginos.funmod.FunMod;
import net.ginos.funmod.world.biome.surface.ModMaterialRules;
import net.minecraft.util.Identifier;
import terrablender.api.Region;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerraBlender implements TerraBlenderApi {

    @Override
    public void onTerraBlenderInitialized() {
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, FunMod.MOD_ID,
                ModMaterialRules.makeRules());
    }
}
