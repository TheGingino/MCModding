package net.ginos.funmod.commands;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class ModCommands {
    public static void registerCommands() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("teleport_corrupted_dim")
                    .executes(context -> {
                        ServerCommandSource source = context.getSource();
                        source.getPlayer().teleport(
                                source.getServer().getWorld(RegistryKey.of(RegistryKey.ofRegistry(Identifier.of("minecraft:dimension")),
                                        Identifier.of("fun-mod:corrupted_dim"))),
                                0, 100, 0, // Coordinates: change as needed
                                source.getPlayer().getYaw(),
                                source.getPlayer().getPitch()
                        );
                        source.sendFeedback((Supplier<Text>) Text.of("Teleported to Corrupted Dimension!"), false);
                        return 1;
                    })
            );
        });
    }
}
