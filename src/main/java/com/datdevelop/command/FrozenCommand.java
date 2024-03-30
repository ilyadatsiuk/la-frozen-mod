package com.datdevelop.command;

import com.datdevelop.util.ModRegistries;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.MinecraftServer;
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
                        .requires(source -> source.hasPermissionLevel(2))
                        .then(CommandManager.argument("nick", EntityArgumentType.player())
                                .then(CommandManager.argument("time", IntegerArgumentType.integer())
                                        .executes(FrozenCommand::run)
                                )
                        )
        );
    }

    private static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerCommandSource src = context.getSource(); // get context
        ServerPlayerEntity player = EntityArgumentType.getPlayer(context, "nick"); // get nick from commnand



        int time = IntegerArgumentType.getInteger(context, "time"); //get time for effect
        //ServerPlayerEntity player = EntityArgumentType.getPlayer(src, "nick");

        //ServerPlayerEntity pl = EntityArgumentType.getPlayer(src, "nick");

        // рабочий код
        //MinecraftServer server = src.getServer(); // get Minecraft server
        //ServerPlayerEntity player = server.getPlayerManager().getPlayer(playerName); // get object of Player


        if (player.isPlayer() && player != null) {
            player.addStatusEffect(new StatusEffectInstance(ModRegistries.FREEZE, time * 20, 1, false, false));
        }
        return 1;
    }
}
