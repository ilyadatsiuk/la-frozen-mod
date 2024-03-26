package com.datdevelop.command;

import com.datdevelop.LaFrozen;
import com.datdevelop.effect.FreezingEffect;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FrozenCommand {
    public static final Logger LOGGER = LoggerFactory.getLogger("la-frozen");

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        LOGGER.info("frozen Command init");
        dispatcher.register(
                CommandManager.literal("frozen")
                        .requires(source -> source.hasPermissionLevel(2))
                        .then(CommandManager.argument("nick", StringArgumentType.string())
                                .then(CommandManager.argument("time", IntegerArgumentType.integer())
                                        .executes(FrozenCommand::run)
                                )
                        )
        );
    }

    private static int run(CommandContext<ServerCommandSource> context) {
        ServerCommandSource src = context.getSource(); // get context
        String playerName = StringArgumentType.getString(context, "nick"); // get nick from commnand
        int time = IntegerArgumentType.getInteger(context, "time"); //get time for effect

        MinecraftServer server = src.getServer(); // get Minecraft server
        ServerPlayerEntity player = server.getPlayerManager().getPlayer(playerName); // get object of Player

        StatusEffect freezingEffect = LaFrozen.FREEZE;

        if (player.isPlayer() && player != null) {
            player.addStatusEffect(new StatusEffectInstance(freezingEffect, time * 20, 1));
        }
        return 1;
    }
}
