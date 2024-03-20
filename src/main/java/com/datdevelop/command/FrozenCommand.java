package com.datdevelop.command;

import com.datdevelop.effect.FreezingEffect;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FrozenCommand {
    public static final Logger LOGGER = LoggerFactory.getLogger("la-frozen");

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        LOGGER.info("frozen Command init");
        dispatcher.register(
                CommandManager.literal("frozen")
                        .then(CommandManager.argument("nick", StringArgumentType.string())
                                .then(CommandManager.argument("time", IntegerArgumentType.integer())
                                        .executes(FrozenCommand::run)
                                )
                        )
        );
    }

    private static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity player = context.getSource().getPlayer();
        int time = IntegerArgumentType.getInteger(context, "time");

        FreezingEffect effect = new FreezingEffect();
        if (player == null){
            return 0;
        }else{
            effect.applyUpdateEffect(player, time*20);
            return 1;
        }
    }
}