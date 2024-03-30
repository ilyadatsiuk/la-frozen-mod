package com.datdevelop.util;

import com.datdevelop.command.FrozenCommand;
import com.datdevelop.effect.FreezingEffect;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRegistries {
    public static final StatusEffect FREEZE = new FreezingEffect();
    public static void registerModStuffs(){
        registerCommands();
        registerEffects();
    }
    private static void registerCommands(){
        CommandRegistrationCallback.EVENT.register((dispatcher, commandRegistryAccess, registrationEnvironment) -> FrozenCommand.register(dispatcher));
    }
    private static void registerEffects(){
        Registry.register(Registries.STATUS_EFFECT, new Identifier("lafrozen", "freeze"), FREEZE);
    }

}
