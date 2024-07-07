package com.datdevelop.command;

import com.datdevelop.LaFrozen;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
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

        if (player.isPlayer() && player != null) {
//            player.addStatusEffect(new StatusEffectInstance(LaFrozen.FREEZEING, time * 20, 1, false, false));
            applyUpdateEffect(player, time*20);
        }
        return 1;
    }

    public static void applyUpdateEffect(ServerPlayerEntity entity, int amplifier) {
        if (entity.isPlayer()) {
            if (entity.getFrozenTicks() < 250 * (amplifier + 1)) {
                entity.setFrozenTicks(entity.getFrozenTicks() + 3 * (amplifier + 1));
                tickFrozenHands(((ServerPlayerEntity) entity));
            }
        }

    }

    private static void tickFrozenHands(ServerPlayerEntity player) {
        boolean mainhand = !player.getMainHandStack().isEmpty();
        boolean offhand = !player.getOffHandStack().isEmpty();
        player.sendMessage(Text.literal("§bВам холодно..."), true);

        if (mainhand && offhand) {
            if (player.getRandom().nextBetween(0, 1) == 0) {
                ItemStack itemStack = player.getMainHandStack().copy();
                itemStack.setCount(1);

                player.dropItem(itemStack, false, true);
                player.getMainHandStack().decrement(1);
            } else {
                ItemStack itemStack = player.getOffHandStack().copy();
                itemStack.setCount(1);
                player.dropItem(itemStack, false, true);
                player.getOffHandStack().decrement(1);
            }
        } else {
            if (mainhand) {
                ItemStack itemStack = player.getMainHandStack().copy();
                itemStack.setCount(1);
                player.dropItem(itemStack, false, true);
                player.getMainHandStack().decrement(1);
            } else {
                ItemStack itemStack = player.getOffHandStack().copy();
                itemStack.setCount(1);
                player.dropItem(itemStack, false, true);
                player.getOffHandStack().decrement(1);
            }
        }
    }
}