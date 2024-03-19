package com.datdevelop.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.command.argument.GameModeArgumentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrozenCommand {
    public static final Logger LOGGER = LoggerFactory.getLogger("la-frozen");

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        LOGGER.info("frozen Command init");
        dispatcher.register(
                CommandManager.literal("frozen")
                        .executes(FrozenCommand::run)
        );
    }
    private static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        LOGGER.info("frozen Command init");
        return 0;
    }


}
