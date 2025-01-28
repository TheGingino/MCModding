package net.ginos.funmod.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.ginos.funmod.FunMod;
import net.ginos.funmod.entity.refiner.RefineData;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<RefinerBlockScreenHandler> REFINER_BLOCK_SCREEN =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(FunMod.MOD_ID, "press_screen"),
                    new ExtendedScreenHandlerType<>(RefinerBlockScreenHandler::new, RefineData.PACKET_CODEC));


    public static void registerScreenHandlers() {
        FunMod.LOGGER.info("Registering Screen Handlers for " + FunMod.MOD_ID);
    }
}
