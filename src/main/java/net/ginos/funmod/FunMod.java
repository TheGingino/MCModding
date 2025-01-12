package net.ginos.funmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.ginos.funmod.block.ModBlocks;
import net.ginos.funmod.commands.ModCommands;
import net.ginos.funmod.component.ModDataComponentTypes;
import net.ginos.funmod.item.ModItems;
import net.ginos.funmod.item.ModItemsGroup;
import net.ginos.funmod.util.SuperCrusherUseEvent;
import net.ginos.funmod.world.dimension.ModDimension;
import net.ginos.funmod.world.gen.ModDimensionGeneration;
import net.ginos.funmod.world.gen.ModWorldGeneration;
import net.kyrptonaught.customportalapi.CustomPortalApiRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;

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

		PlayerBlockBreakEvents.BEFORE.register(new SuperCrusherUseEvent());

		CompostingChanceRegistry.INSTANCE.add(ModItems.BLUEBERRY, 0.15f);

		StrippableBlockRegistry.register(ModBlocks.CRACKED_PINE_LOG, ModBlocks.STRIPPED_CRACKED_PINE_LOG);
		StrippableBlockRegistry.register(ModBlocks.CRACKED_PINE_WOOD, ModBlocks.STRIPPED_CRACKED_PINE_WOOD);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CRACKED_PINE_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CRACKED_PINE_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CRACKED_PINE_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CRACKED_PINE_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CRACKED_PINE_PLANKS, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CRACKED_PINE_LEAVES, 5, 5);
		ModWorldGeneration.generateModWorldGen();
		ModCommands.registerCommands();

		CustomPortalBuilder.beginPortal()
				.frameBlock(ModBlocks.MAGIC_BLOCK)
				.lightWithItem(ModItems.FRIKANDEL)
				.destDimID(Identifier.of(FunMod.MOD_ID, "corrupted_dim"))
				.tintColor(45,65,121)
				.registerPortal();

	}
}