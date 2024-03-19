package com.datdevelop;

import com.datdevelop.command.FrozenCommand;
import com.datdevelop.util.ModRegistries;
import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.api.ModInitializer;
import net.minecraft.server.command.ServerCommandSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LaFrozen implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("la-frozen");
	private static CommandDispatcher<ServerCommandSource> dispatcher = new CommandDispatcher<ServerCommandSource>();
	@Override
	public void onInitialize() {
		LOGGER.info("la-frozen Mod is loaded");
		FrozenCommand command = new FrozenCommand();

		ModRegistries.registerModStuffs();
	}


}
