package com.datdevelop;

import com.datdevelop.effect.FreezingEffect;
import com.datdevelop.util.ModRegistries;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LaFrozen implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("la-frozen");

	@Override
	public void onInitialize() {
		LOGGER.info("la-frozen Mod is loaded");

		StatusEffect FREEZE = new FreezingEffect();
		Registry.register(Registries.STATUS_EFFECT, new Identifier("lafrozen", "freeze"), FREEZE);
		ModRegistries.registerModStuffs();

	}

}
