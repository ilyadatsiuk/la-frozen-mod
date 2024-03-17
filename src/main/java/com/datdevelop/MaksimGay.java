package com.datdevelop;
import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mojang.brigadier.arguments.IntegerArgumentType.integer;
import static com.mojang.brigadier.builder.LiteralArgumentBuilder.literal;
import static com.mojang.brigadier.builder.RequiredArgumentBuilder.argument;
import static java.lang.Integer.getInteger;

import com.mojang.brigadier.arguments.IntegerArgumentType;

public class MaksimGay implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("maksimgay");
	private static CommandDispatcher<Object> dispatcher = new CommandDispatcher<Object>();

	@Override
	public void onInitialize() {
		dispatcher.register(
			literal("foo")
				.then(
					argument("bar", IntegerArgumentType.integer())
						.executes(c -> {
							int bar = IntegerArgumentType.getInteger(c, "bar");
							System.out.println("Bar is " + bar);
							return 1;
					})
				)
				.executes(c -> {
			System.out.println("Called foo with no arguments");
			return 1;
			})
		);
		LOGGER.info("Hello Fabric world!");
	}


}
