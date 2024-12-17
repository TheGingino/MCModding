package net.ginos.funmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.ginos.funmod.block.ModBlocks;
import net.ginos.funmod.component.ModDataComponentTypes;
import net.ginos.funmod.item.ModItems;
import net.ginos.funmod.item.ModItemsGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FunMod implements ModInitializer {
	public static final String MOD_ID = "fun-mod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemsGroup.registerItemGroups();

		ModItems.RegisterModItems();
		ModBlocks.RegisterModBlocks();

		ModDataComponentTypes.registerDataComponentTypes();
		FuelRegistry.INSTANCE.add(ModItems.BURNT_COAL, 600);
		LOGGER.info("Hello Fabric world!");
	}
}