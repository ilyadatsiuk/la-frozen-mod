package com.datdevelop.util;

import com.datdevelop.command.FrozenCommand;
import com.datdevelop.effect.FreezingEffect;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.fabricmc.loader.impl.util.log.Log.log;

public class ModRegistries {
    static Log log = new Log();
    public static void registerModStuffs(){
        registerCommands();

    }
    private static void registerCommands(){
        CommandRegistrationCallback.EVENT.register((dispatcher, commandRegistryAccess, registrationEnvironment) -> FrozenCommand.register(dispatcher));
    }

}
