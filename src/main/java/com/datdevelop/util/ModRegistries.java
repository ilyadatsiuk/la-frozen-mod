package com.datdevelop.util;

import com.datdevelop.command.FrozenCommand;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public class ModRegistries {
    public static void registerModStuffs(){
        registerCommands();
    }
    private static void registerCommands(){
        CommandRegistrationCallback.EVENT.register(FrozenCommand::register);
    }
}
