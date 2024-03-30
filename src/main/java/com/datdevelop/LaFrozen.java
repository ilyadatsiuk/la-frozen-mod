package com.datdevelop;

import com.datdevelop.util.ModRegistries;
import net.fabricmc.api.ModInitializer;

public class LaFrozen implements ModInitializer {

	@Override
	public void onInitialize() {
		ModRegistries.registerModStuffs();

	}
}
