package com.datdevelop;

import com.datdevelop.command.FrozenCommand;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LaFrozen implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("la-frozen");
	@Override
	public void onInitialize() {
		LOGGER.info("la-frozen Mod is loaded");
		FrozenCommand command = new FrozenCommand();
		command.initCommand();
	}


}
