package com.datdevelop.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrozenCommand {
    public static final Logger LOGGER = LoggerFactory.getLogger("la-frozen");

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
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
