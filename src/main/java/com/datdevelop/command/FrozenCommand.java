package com.datdevelop.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import java.util.function.Supplier;

import static net.minecraft.server.command.CommandManager.literal;

public class FrozenCommand{
    private static final CommandDispatcher<ServerCommandSource> dispatcher = new CommandDispatcher<>();
    public void initCommand() {
        dispatcher.register(literal("frozen").requires(source -> source.hasPermissionLevel(2)).executes(ctx -> {
            ctx.getSource().sendFeedback((Supplier<Text>) Text.of("You are an operator"), false);
            return 1;
            })
        );

    }
}
